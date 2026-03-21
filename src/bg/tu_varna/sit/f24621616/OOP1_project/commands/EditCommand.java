package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.DoubleCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.FormulaCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.IntegerCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.StringCell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;

public class EditCommand implements Command {
    private CurrentState currentState;
    private int row;
    private int col;
    private String newValue;

    public EditCommand(CurrentState currentState, int row, int col, String newValue) {
        this.currentState = currentState;
        this.row = row;
        this.col = col;
        this.newValue = newValue;
    }

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
            currentState.getCurrentTable().setCell(row, col, newCell);
            return "Successfully edited cell R" + row + "C" + col;
        } else {
            throw new IllegalArgumentException("No file is currently open.");
        }
    }
}
