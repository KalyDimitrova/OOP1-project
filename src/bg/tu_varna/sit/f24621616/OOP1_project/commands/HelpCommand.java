package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("The following commands are supported:\n" +
                "open <file>     opens <file>\n" +
                "close           closes currently opened file\n" +
                "save            saves the currently open file\n" +
                "save as <file>  saves the currently open file in <file>\n" +
                "help            prints this information\n" +
                "exit            exists the program");
    }
}
