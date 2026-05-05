package bg.tu_varna.sit.f24621616.OOP1_project.interfaces;

/**
 * Represents a command in the application.
 */
public interface Command {
    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments passed to the command
     * @return the description of the action caused by the command
     */
    public String execute(String[] args);
}