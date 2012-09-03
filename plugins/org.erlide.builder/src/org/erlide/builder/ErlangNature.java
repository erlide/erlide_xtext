package org.erlide.builder;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ErlangNature implements IProjectNature {

    private IProject project;

    @Override
    public void configure() throws CoreException {
        final IProjectDescription desc = project.getDescription();
        final ICommand[] commands = desc.getBuildSpec();

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(ErlangBuilder.BUILDER_ID)) {
                return;
            }
        }

        final ICommand[] newCommands = new ICommand[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        final ICommand command = desc.newCommand();
        command.setBuilderName(ErlangBuilder.BUILDER_ID);
        newCommands[newCommands.length - 1] = command;
        desc.setBuildSpec(newCommands);

        project.setDescription(desc, null);
    }

    @Override
    public void deconfigure() throws CoreException {
        final IProjectDescription description = getProject().getDescription();
        final ICommand[] commands = description.getBuildSpec();
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(ErlangBuilder.BUILDER_ID)) {
                final ICommand[] newCommands = new ICommand[commands.length - 1];
                System.arraycopy(commands, 0, newCommands, 0, i);
                System.arraycopy(commands, i + 1, newCommands, i,
                        commands.length - i - 1);
                description.setBuildSpec(newCommands);
                project.setDescription(description, null);
                return;
            }
        }
    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(final IProject project) {
        this.project = project;
    }

}
