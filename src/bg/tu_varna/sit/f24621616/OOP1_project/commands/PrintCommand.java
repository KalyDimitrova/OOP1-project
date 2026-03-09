package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class PrintCommand implements Command {
    private CurrentState state;

    public PrintCommand(CurrentState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        if (state.isFileIsOpen()) {
            // TODO follow the formatting!
            System.out.println(state.getCurrentTable());
        } else {
            System.out.println("No file is currently open.");
        }
    }
}
