package org.erlide.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.RecordFieldDef;
import org.erlide.erlang.util.ErlangSwitch;

import com.google.inject.Inject;

public class ErlangQualifiedNameProvider extends
		DefaultDeclarativeQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		final String name = new ErlangSwitch<String>() {

			@Override
			public String caseModule(final Module object) {
				String mod = ModelExtensions.getName(object);
				if (mod == null) {
					return object.eResource().getURI().lastSegment();
				}
				return mod;
			}

			@Override
			public String caseFunction(final Function object) {
				final StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(":");
				sb.append(object.getName());
				sb.append("/");
				sb.append(ModelExtensions.getArity(object));
				return sb.toString();
			}

			@Override
			public String caseFunctionClause(final FunctionClause object) {
				final StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(":");
				sb.append(getIndexInParent(object));
				return sb.toString();
			}

			@Override
			public String caseDefineAttribute(final DefineAttribute object) {
				final StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(":");
				sb.append("?");
				sb.append(object.getMacroName());
				return sb.toString();
			}

			@Override
			public String caseRecordAttribute(final RecordAttribute object) {
				final StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(":");
				sb.append("#");
				sb.append(object.getName());
				sb.append("_");
				sb.append(getIndexInParent(object));
				return sb.toString();
			}

			@Override
			public String caseRecordFieldDef(final RecordFieldDef object) {
				final StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(":");
				sb.append(object.getName());
				return sb.toString();
			}

			@Override
			public String caseFunExpr(org.erlide.erlang.FunExpr object) {
				final StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(":");
				sb.append("fun_");
				sb.append(getIndexInParent(object));
				return sb.toString();
			};

			@Override
			public String defaultCase(EObject object) {
				if (object == null) {
					return null;
				}
				return doSwitch(object.eContainer());
			};

			private int getIndexInParent(EObject object) {
				EObject parent = object.eContainer();
				return parent.eContents().indexOf(object);
			}

		}.doSwitch(obj);

		QualifiedName result;
		if (name == null) {
			result = null; // super.getFullyQualifiedName(obj);
		} else {
			result = qualifiedNameConverter.toQualifiedName(name);
		}
		return result;
	}
}
