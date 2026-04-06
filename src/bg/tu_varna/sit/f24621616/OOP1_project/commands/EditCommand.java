package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.DoubleCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.FormulaCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.IntegerCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.StringCell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

/**
 * Represents an edit that needs to be done in the current table of the application
 */
public class EditCommand implements Command {
    private CurrentState currentState;
    private int row;
    private int col;
    private String newValue;

    /**
     * Creates an Edit command with the given state,
     * the location of the cell to be edited
     * and the value to put in said cell.
     *
     * @param currentState the current state of the application
     * @param row the row of the cell to edit
     * @param col the col of the cell to edit
     * @param newValue the new value to put in said cell
     */
    public EditCommand(CurrentState currentState, int row, int col, String newValue) {
        this.currentState = currentState;
        this.row = row;
        this.col = col;
        this.newValue = newValue;
    }

    /**
     * Checks if a file is open.
     * Creates a new cell with the new value and sets it in place of the cell to edit.
     * Throws an exception if no file is currently open.
     *
     * @return a success message with the edited cell
     */
    @Override
    public String execute() {
        if (currentState.isFileIsOpen()) {
            Cell newCell;
            if (newValue.startsWith("\"")) {
                newCell = new StringCell(newValue);
            } else if (newValue.startsWith("=")) {
                newCell = new FormulaCell(newValue, currentState.getCurrentTable());
            } else if (newValue.contains(".")) {
                newCell = new DoubleCell(Double.parseDouble(newValue));
            } else {
                newCell = new IntegerCell(Integer.parseInt(newValue));
            }
            currentState.getCurrentTable().setCell(row - 1, col - 1, newCell);
            return "Successfully edited cell R" + row + "C" + col;
        } else {
            throw new IllegalArgumentException("No file is currently open.");
        }
    }
}
