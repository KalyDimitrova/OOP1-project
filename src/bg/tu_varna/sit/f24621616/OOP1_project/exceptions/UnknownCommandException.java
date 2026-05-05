package bg.tu_varna.sit.f24621616.OOP1_project.exceptions;

/**
 * Thrown when a command is not recognized.
 */
public class UnknownCommandException extends RuntimeException {
    /**
     * Creates a UnknownCommandException with the given message.
     *
     * @param message the error message
     */
    public UnknownCommandException(String message) {
        super(message);
    }
}
