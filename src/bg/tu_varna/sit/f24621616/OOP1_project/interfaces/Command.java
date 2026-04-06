package bg.tu_varna.sit.f24621616.OOP1_project.interfaces;

/**
 * Represents a command in the application.
 */
public interface Command {
    /**
     * Returns the description of what the command has done.
     *
     * @return the description of the action caused by the command
     */
    public String execute();
}
