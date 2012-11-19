package org.erlide.ui.containers;

import org.eclipse.xtext.resource.containers.IAllContainersState;

import com.google.inject.Provider;

public class WorkspaceProjectsStateProvider implements
        Provider<IAllContainersState> {

    private WorkspaceProjectsState state;

    @Override
    public IAllContainersState get() {
        if (state == null) {
            state = new WorkspaceProjectsState();

        }
        return state;
    }

}
