package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class CloseCommand implements Command {
    private CurrentState state;

    public CloseCommand(CurrentState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        if (state.isFileIsOpen()) {
            state.setCurrentTable(null);
            String currentFilePath = state.getFilePath();
            state.setFilePath(null);
            state.setFileIsOpen(false);
            System.out.println("Successfully closed " + currentFilePath);
        } else {
            System.out.println("No file is currently open.");
        }
    }
}
