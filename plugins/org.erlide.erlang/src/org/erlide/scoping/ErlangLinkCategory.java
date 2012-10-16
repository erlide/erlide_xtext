package org.erlide.scoping;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;

import com.google.inject.Inject;

public enum ErlangLinkCategory {
    NONE {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return null;
        }
    },
    MODULE {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getModuleRef(index, atom, rset);
        }
    },
    FUNCTION_CALL_LOCAL {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getLocalCallRef(index, atom, rset);
        }
    },
    FUNCTION_CALL_REMOTE {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getRemoteCallRef(index, atom, rset);
        }
    },
    FUNCTION_REF_LOCAL {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getLocalFunRefRef(index, atom, rset);
        }
    },
    FUNCTION_REF_REMOTE {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getRemoteFunRefRef(index, atom, rset);
        }
    },
    RECORD {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getRecordRef(index, atom, rset);
        }
    },
    RECORD_FIELD {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getRecordFieldRef(index, atom, rset);
        }
    },
    TYPE_DEF {
        @Override
        public AtomRefTarget getRef(final IResourceDescriptions index,
                final Atom atom, final ResourceSet rset) {
            return helper.getTypeRef(index, atom, rset);
        }
    };

    @Inject
    private static ErlangLinkingHelper helper;

    public abstract AtomRefTarget getRef(IResourceDescriptions index,
            Atom atom, ResourceSet rset);

}
