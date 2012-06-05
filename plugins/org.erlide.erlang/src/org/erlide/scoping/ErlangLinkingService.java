package org.erlide.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.erlide.erlang.Atom;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordField;
import org.erlide.erlang.RemoteTarget;

import com.google.inject.Inject;

public class ErlangLinkingService extends DefaultLinkingService {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private ModelExtensions modelExtensions;

	@Override
	public String getCrossRefNodeAsString(final INode node)
			throws IllegalNodeException {
		String result = super.getCrossRefNodeAsString(node);
		System.out.println(NodeModelUtils.getTokenText(node) + " >>" + result
				+ "<< ");
		final EObject element = NodeModelUtils
				.findActualSemanticObjectFor(node);
		System.out.println(element);

		if (element instanceof Atom) {
			final Atom atom = (Atom) element;
			if (atom.eContainer() instanceof RemoteTarget) {
				final RemoteTarget parent = (RemoteTarget) atom.eContainer();

				if (isFunctionRef(parent, node)) {
					final FunCall fc = (FunCall) parent.eContainer();
					final int arity = fc.getArgs().size();
					final ICompositeNode pnode = NodeModelUtils.getNode(parent);
					final RemoteTarget o = (RemoteTarget) NodeModelUtils
							.findActualSemanticObjectFor(pnode);
					final String mm = NodeModelUtils
							.getTokenText(NodeModelUtils.getNode(o.getModule()));
					result = mm + ":" + NodeModelUtils.getTokenText(node) + "/"
							+ arity;
				}
			} else if (atom.eContainer() instanceof FunCall) {
				final FunCall fc = (FunCall) atom.eContainer();
				final int arity = fc.getArgs().size();
				result = modelExtensions.getName(getModule(atom)) + ":"
						+ NodeModelUtils.getTokenText(node) + "/" + arity;
			}
		} else if (element instanceof FunRef) {
			final FunRef ref = (FunRef) element;
			System.out.println("REF:: "
					+ NodeModelUtils.compactDump(NodeModelUtils.getNode(ref),
							true));
			// TODO check for variables, macros, etc
			result = node.getParent().getText().trim();
			System.out.println("XXX -" + result + "-");
			System.out.println(element.eContainer());

		} else if (element instanceof RecordExpr) {
			final RecordExpr rec = (RecordExpr) element;
			final Module m = getModule(rec);
			result = modelExtensions.getName(m) + ":#" + node.getText();
			System.out.println("RRR " + node.getText());
			System.out.println(element.eContainer());

		} else if (element instanceof RecordField) {
			final RecordField frec = (RecordField) element;
			final Module m = getModule(frec);
			result = modelExtensions.getName(m) + ":" + node.getText();
			System.out.println("ZZZ " + node.getText());
			System.out.println(element.eContainer());
		}

		System.out.println("%%>> " + element + " = " + result);
		return result;
	}

	private boolean isFunctionRef(final RemoteTarget parent, final INode node) {
		final ICompositeNode p = NodeModelUtils.getNode(parent);
		INode prev = null;
		final boolean flag = false;
		for (final INode n : p.getLeafNodes()) {
			if (n.getParent() == node) {
				break;
			}
			prev = n;
		}
		if (prev != null && prev.getText().equals(":")) {
			return true;
		}
		return false;
	}

	private boolean isModuleRef(final RemoteTarget parent, final INode node) {
		final ICompositeNode p = NodeModelUtils.getNode(parent);
		INode next = null;
		boolean flag = false;
		for (final INode n : p.getLeafNodes()) {
			if (flag) {
				next = n;
				break;
			}
			if (n.getParent() == node) {
				flag = true;
			}
		}
		if (next != null && next.getText().equals(":")) {
			return true;
		}
		return false;
	}

	private Module getModule(EObject object) {
		while (!(object instanceof Module)) {
			object = object.eContainer();
		}
		return (Module) object;
	}

}
