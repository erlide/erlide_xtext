package org.erlide.scoping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.erlide.erlang.ConditionalFormBlock;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Form;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
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
                final Form attribute = object.getForms().get(0);
                if (attribute instanceof ModuleAttribute) {
                    final String key = ((ModuleAttribute) attribute).getName();
                    return key;
                }
                return null;
            }

            @Override
            public String caseConditionalFormBlock(
                    final ConditionalFormBlock object) {
                return doSwitch(object.eContainer());
            }

            @Override
            public String caseFunction(final Function object) {
                final StringBuilder sb = new StringBuilder();
                sb.append(doSwitch(object.eContainer()));
                sb.append(":");
                sb.append(object.getName());
                sb.append("/");

                final EList<FunctionClause> clauses = object.getClauses();
                if (clauses == null || clauses.isEmpty()) {
                    sb.append("?");
                } else {
                    final EList<Expression> params = clauses.get(0).getParams();
                    final int arity = params == null ? 0 : params.size();
                    sb.append(arity);
                }
                return sb.toString();
            }

            @Override
            public String caseDefineAttribute(final DefineAttribute object) {
                final StringBuilder sb = new StringBuilder();
                // sb.append(doSwitch(object.eContainer()));
                // sb.append(":");
                sb.append("?");
                sb.append(object.getName());
                return sb.toString();
            }

            @Override
            public String caseRecordAttribute(final RecordAttribute object) {
                final StringBuilder sb = new StringBuilder();
                sb.append(doSwitch(object.eContainer()));
                sb.append(":");
                sb.append("#");
                sb.append(object.getName());
                return sb.toString();
            }

            @Override
            public String caseRecordFieldDef(final RecordFieldDef object) {
                final StringBuilder sb = new StringBuilder();
                sb.append(doSwitch(object.eContainer()));
                sb.append(":");
                // FIXME
                sb.append(object.getName());
                return sb.toString();
            }

            private EObject getModule(EObject object) {
                while (!(object instanceof Module)) {
                    object = object.eContainer();
                }
                return object;
            }

        }.doSwitch(obj);

        QualifiedName result;
        if (name == null) {
            result = null; // super.getFullyQualifiedName(obj);
        } else {
            result = qualifiedNameConverter.toQualifiedName(name);
        }
        if (result != null) {
            // System.out.println(">> " + obj + " = " + result);
        }
        return result;
    }

}
