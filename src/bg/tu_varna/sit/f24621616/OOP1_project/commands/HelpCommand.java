package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

/**
 * Represents a Help menu for all commands of the application.
 */
public class HelpCommand implements Command {
    /**
     * Returns descriptions of all commands of the application.
     *
     * @return description of all commands
     */
    @Override
    public String execute() {
        return """
                The following commands are supported:
                open <file>     opens <file>
                close           closes currently opened file
                save            saves the currently open file
                save as <file>  saves the currently open file in <file>
                help            prints this information
                exit            exists the program""";
    }
}
