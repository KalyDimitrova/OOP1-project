package bg.tu_varna.sit.f24621616.OOP1_project;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;
import bg.tu_varna.sit.f24621616.OOP1_project.parser.CommandParser;

import java.util.Scanner;

/**
 * Represents the application itself.
 */
public class Application {
    /**
     * Starts the application and runs the main command loop.
     * Reads user input, parses it into commands and executes them.
     * Prints the result or error message after each command.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        CurrentState currentState = new CurrentState();
        CommandParser parser = new CommandParser();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("-> ");
            String input = scanner.nextLine();

            try {
                Command command = parser.parse(input, currentState);
                String result = command.execute();
                System.out.println(result);
                if (input.trim().toLowerCase().equals("exit")) {
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}