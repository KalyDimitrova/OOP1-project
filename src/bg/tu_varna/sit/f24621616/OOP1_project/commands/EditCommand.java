package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.DoubleCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.FormulaCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.IntegerCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.StringCell;
import bg.tu_varna.sit.f24621616.OOP1_project.exceptions.InvalidValueException;
import bg.tu_varna.sit.f24621616.OOP1_project.exceptions.NoFileOpenException;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

/**
 * Represents an edit that needs to be done in the current table of the application
 */
public class EditCommand implements Command {
    /** The current state of the application. */
    private CurrentState currentState;


    /**
     * Creates an EditCommand with the given state,
     * the location of the cell to be edited
     * and the value to put in said cell.
     *
     * @param currentState the current state of the application
     */
    public EditCommand(CurrentState currentState) {
        this.currentState = currentState;
    }

    /**
     * Checks if a file is open.
     * Creates a new cell with the new value and sets it in place of the cell to edit.
     * Throws an exception if no file is currently open.
     *
     * @param args args[1] is the row, args[2] is the column, args[3] is the new value
     * @return a success message with the edited cell
     */
    @Override
    public String execute(String[] args) {
        int row = Integer.parseInt(args[1]);
        int col = Integer.parseInt(args[2]);
        String newValue = args[3];

        if (currentState.isFileIsOpen()) {
            Cell newCell;
            if (newValue.startsWith("\"")) {
                newCell = new StringCell(newValue);
            } else if (newValue.startsWith("=")) {
                newCell = new FormulaCell(newValue, currentState.getCurrentTable());
            } else if (newValue.contains(".")) {
                try {
                    newCell = new DoubleCell(Double.parseDouble(newValue));
                } catch (NumberFormatException e) {
                    throw new InvalidValueException("Invalid value: " + newValue);
                }
            } else {
                try {
                    newCell = new IntegerCell(Integer.parseInt(newValue));
                } catch (NumberFormatException e) {
                    throw new InvalidValueException("Invalid value: " + newValue);
                }
            }
            currentState.getCurrentTable().setCell(row - 1, col - 1, newCell);
            return "Successfully edited cell R" + row + "C" + col;
        } else {
            throw new NoFileOpenException("No file is currently open.");
        }
    }
}
