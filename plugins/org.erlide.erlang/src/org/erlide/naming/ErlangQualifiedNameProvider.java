package org.erlide.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Function;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.RecordFieldDef;
import org.erlide.erlang.TypeAttribute;

import com.google.inject.Inject;

public class ErlangQualifiedNameProvider extends
		DefaultDeclarativeQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter converter;
	@Inject
	private ModelExtensions modelExtensions;

	QualifiedName qualifiedName(final Module module) {
		String name = modelExtensions.getName(module);
		if (name == null) {
			// TODO this isn't very unique! we should use the physical path, or
			// something
			name = module.eResource().getURI().lastSegment()
					.replaceAll("\\.", "_");
		}
		return QualifiedName.create(name);
	}

	QualifiedName qualifiedName(final DefineAttribute macro) {
		return splice(getParentsFullyQualifiedName(macro),
				converter.toQualifiedName(macro.getMacroName()));
	}

	QualifiedName qualifiedName(final RecordAttribute record) {
		return splice(getParentsFullyQualifiedName(record),
				converter.toQualifiedName(record.getName()));
	}

	QualifiedName qualifiedName(final RecordFieldDef field) {
		return splice(getParentsFullyQualifiedName(field),
				converter.toQualifiedName(field.getName()));
	}

	QualifiedName qualifiedName(final Function function) {
		return splice(
				getParentsFullyQualifiedName(function),
				converter.toQualifiedName(function.getName() + "/"
						+ modelExtensions.getArity(function)));
	}

	QualifiedName qualifiedName(final Expression expression) {
		// TODO
		return null;
	}

	QualifiedName qualifiedName(final TypeAttribute type) {
		return splice(getParentsFullyQualifiedName(type),
				converter.toQualifiedName(type.getName()));
	}

	public static QualifiedName splice(final QualifiedName a,
			final QualifiedName b) {
		return a == null ? b : a.append(b);
	}

	/**
	 * The fully qualified name of the closest named parent.
	 */
	QualifiedName getParentsFullyQualifiedName(final EObject o) {
		for (EObject tmp = o.eContainer(); tmp != null; tmp = tmp.eContainer()) {
			final QualifiedName n = getFullyQualifiedName(tmp);
			if (n != null) {
				return n;
			}
		}
		return null;
	}

}
