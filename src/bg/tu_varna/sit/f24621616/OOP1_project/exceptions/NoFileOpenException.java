package bg.tu_varna.sit.f24621616.OOP1_project.exceptions;

/**
 * Thrown when trying to execute a command on a file that is not opened.
 */
public class NoFileOpenException extends RuntimeException {
    /**
     * Creates a NoFileOpenException with the given message.
     *
     * @param message the error message
     */
    public NoFileOpenException(String message) {
        super(message);
    }
}
