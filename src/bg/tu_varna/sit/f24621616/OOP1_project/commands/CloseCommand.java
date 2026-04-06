package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

/**
 * Represents the closing of an open file.
 */
public class CloseCommand implements Command {
    private CurrentState state;

    /**
     * Creates a CloseCommand with the given application state.
     *
     * @param state the current state of the application
     */
    public CloseCommand(CurrentState state) {
        this.state = state;
    }

    /**
     * Closes the currently open file and clears the application state.
     * Throws an exception if no file is currently open.
     *
     * @return a success message with the closed file name
     */
    @Override
    public String execute() {
        if (state.isFileIsOpen()) {
            state.setCurrentTable(null);
            String currentFilePath = state.getFilePath();
            state.setFilePath(null);
            state.setFileIsOpen(false);
            return "Successfully closed " + currentFilePath;
        } else {
            throw new IllegalArgumentException("No file is currently open.");
        }
    }
}
