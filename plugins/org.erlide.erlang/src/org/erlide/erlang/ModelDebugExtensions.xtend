package org.erlide.erlang

import java.io.IOException
import java.io.StringWriter
import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMIResource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl

class ModelDebugExtensions {
	
	def String debugPrint(EObject m) {
		EcoreUtil::copy(m).serialize
	}
	
	def String serialize(EObject root) throws IOException {
		if (root == null) {
			throw new NullPointerException("ModelUtils.NullSaveRoot"); //$NON-NLS-1$
		}
		val XMIResource newResource = new XMIResourceImpl();
		val  StringWriter writer = new StringWriter();
		newResource.getContents().add(root);
		newResource.save(writer, Collections::EMPTY_MAP);
		return writer.toString();
	}
	
	
}