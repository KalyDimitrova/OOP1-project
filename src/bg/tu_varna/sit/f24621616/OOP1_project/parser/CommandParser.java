package bg.tu_varna.sit.f24621616.OOP1_project.parser;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.commands.*;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class CommandParser {
    public Command parse(String input, CurrentState state) {
        String[] parts = input.trim().split(" ",4);
        String command = parts[0].toLowerCase();

        switch (command) {
            case "open": if (parts.length < 2) {
                throw new IllegalArgumentException("Usage: open <file>");
            }
                return new OpenCommand(state, parts[1]);
            case "close": return new CloseCommand(state);
            case "save":
                if (parts.length > 1 && parts[1].equalsIgnoreCase("as")) {
                    if (parts.length < 3) {
                        throw new IllegalArgumentException("Usage: save as <file>");
                    }
                    return new SaveAsCommand(state, parts[2]);
                }
                return new SaveCommand(state);
            case "print": return new PrintCommand(state);
            case "edit":
                if (parts.length < 4) {
                    throw new IllegalArgumentException("Usage: edit <row> <col> <value>");
                }
                return new EditCommand(state, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]);
            case "help": return new HelpCommand();
            case "exit": return new ExitCommand();
            default: throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
