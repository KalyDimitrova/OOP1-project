package bg.tu_varna.sit.f24621616.OOP1_project.exceptions;

/**
 * Thrown when value does not match the expected format.
 */
public class InvalidValueException extends RuntimeException {
    /**
     * Creates a InvalidValueException with the given message.
     *
     * @param message the error message
     */
    public InvalidValueException(String message) {
        super(message);
    }
}
