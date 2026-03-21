package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class PrintCommand implements Command {
    private CurrentState state;

    public PrintCommand(CurrentState state) {
        this.state = state;
    }

    @Override
    public String execute() {
        if (state.isFileIsOpen()) {
            // TODO follow the formatting!!!
            return state.getCurrentTable().toString();
        } else {
            throw new IllegalArgumentException("No file is currently open.");
        }
    }
}
