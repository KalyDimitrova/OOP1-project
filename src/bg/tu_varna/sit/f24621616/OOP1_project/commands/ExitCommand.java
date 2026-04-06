package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

/**
 * Represents the exiting of the application.
 */
public class ExitCommand implements Command {
    /**
     * Exits the program and prints the exiting message.
     *
     * @return the exiting message
     */
    @Override
    public String execute() {
        return "Exiting the program...";
    }
}
