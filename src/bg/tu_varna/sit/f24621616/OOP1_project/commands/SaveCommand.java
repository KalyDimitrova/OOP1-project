package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class SaveCommand implements Command {
    private CurrentState state;

    public SaveCommand(CurrentState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        if (state.isFileIsOpen()) {
            // TODO save the file!
            System.out.println("Successfully saved " + state.getFilePath());
        } else {
            System.out.println("No file is currently open.");
        }
    }
}
