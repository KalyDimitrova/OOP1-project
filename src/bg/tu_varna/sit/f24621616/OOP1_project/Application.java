package bg.tu_varna.sit.f24621616.OOP1_project;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.parser.CommandParser;

import java.util.Scanner;

/**
 * Represents the application itself.
 */
public class Application {
    /**
     * Starts the application and runs the main command loop.
     * Reads user input, passes it into the parser and prints the result.
     * Prints the error message if an exception is thrown.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        CurrentState currentState = new CurrentState();
        CommandParser parser = new CommandParser(currentState);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("-> ");
            String input = scanner.nextLine();

            try {
                String result = parser.parse(input);
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