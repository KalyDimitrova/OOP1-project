package bg.tu_varna.sit.f24621616.OOP1_project.parser;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.commands.*;
import bg.tu_varna.sit.f24621616.OOP1_project.exceptions.InvalidValueException;
import bg.tu_varna.sit.f24621616.OOP1_project.exceptions.UnknownCommandException;
import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a parser for the input from the client.
 */
public class CommandParser {
    private Map<String, Command> commandMap = new HashMap<>();
    private CurrentState state;

    public CommandParser(CurrentState state) {
        this.state = state;

        commandMap.put("open", new OpenCommand(state));
        commandMap.put("close", new CloseCommand(state));
        commandMap.put("save", new SaveCommand(state));
        commandMap.put("save as", new SaveAsCommand(state));
        commandMap.put("print", new PrintCommand(state));
        commandMap.put("edit", new EditCommand(state));
        commandMap.put("help", new HelpCommand());
        commandMap.put("exit", new ExitCommand());
    }

    /**
     * Parses the input from the client and returns the matching command.
     * Splits the input into parts and matches the first part to a command.
     *
     * @param input the line typed by the client
     * @return the command matching the input
     * @throws UnknownCommandException if the command is not recognized
     * @throws InvalidValueException if required parameters are missing
     */
    public String parse(String input) {
        String[] parts = input.trim().split(" ",4);
        String commandName = parts[0].toLowerCase();

        if (commandName.equals("save") && parts.length > 1 && parts[1].equalsIgnoreCase("as")) {
            commandName = "save as";
        }

        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new UnknownCommandException("Unknown command: " + commandName);
        }

        if (commandName.equals("open") && parts.length < 2) {
            throw new InvalidValueException("Usage: open <file>");
        }
        if (commandName.equals("edit") && parts.length < 4) {
            throw new InvalidValueException("Usage: edit <row> <col> <value>");
        }
        if (commandName.equals("save as") && parts.length < 3) {
            throw new InvalidValueException("Usage: save as <file>");
        }

        return command.execute(parts);
    }
}
