package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class SaveAsCommand implements Command {
    private CurrentState state;
    private String newFilePath;

    public SaveAsCommand(CurrentState state, String newFilePath) {
        this.state = state;
        this.newFilePath = newFilePath;
    }

    @Override
    public String execute() {
        if (state.isFileIsOpen()) {
            // TODO save the file as the new file path from user input!
            state.setFilePath(newFilePath);
            return "Successfully saved " + newFilePath;
        } else {
            throw new IllegalArgumentException("No file is currently open.");
        }
    }
}
