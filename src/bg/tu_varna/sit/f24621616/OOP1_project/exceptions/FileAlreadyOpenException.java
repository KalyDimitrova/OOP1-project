package bg.tu_varna.sit.f24621616.OOP1_project.exceptions;

/**
 * Thrown when trying to open a file while one is already open.
 */

public class FileAlreadyOpenException extends RuntimeException {
    /**
     * Creates a FileAlreadyOpenException with the given message.
     *
     * @param message the error message
     */
    public FileAlreadyOpenException(String message) {
        super(message);
    }
}
