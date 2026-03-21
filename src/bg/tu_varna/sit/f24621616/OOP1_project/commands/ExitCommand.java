package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class ExitCommand implements Command {
    @Override
    public String execute() {
        return "Exiting the program...";
    }
}
