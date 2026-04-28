package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.FormulaCell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;
import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

/**
 * Represents the printing of the current table.
 */
public class PrintCommand implements Command {
    /**
     * The current state of the application
     */
    private CurrentState state;

    /**
     * Creates a PrintCommand with the given application state.
     *
     * @param state the current state of the application
     */
    public PrintCommand(CurrentState state) {
        this.state = state;
    }

    /**
     * Prints the current table with aligned columns separated by '|'.
     * Formula cells display their calculated result.
     * Throws an exception if no file is currently open.
     *
     * @return the formatted table as a String
     */
    @Override
    public String execute() {
        if (state.isFileIsOpen()) {
            Table table = state.getCurrentTable();

            int[] columnWidths = new int[table.getColumnCount()];

            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Cell cell = table.getCell(i, j);

                    if (cell != null) {
                        int cellWidth = cell.toString().length();

                        if (cellWidth > columnWidths[j]) {
                            columnWidths[j] = cellWidth;
                        }
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Cell cell = table.getCell(i, j);
                    String value;

                    if (cell == null) {
                        value = "";
                    } else if (cell instanceof FormulaCell) {
                        value = ((FormulaCell) cell).getDisplayValue();
                    } else {
                        value = cell.toString();
                    }

                    output.append(String.format("%-" + columnWidths[j] + "s", value));
                    output.append(" | ");
                }
                output.append("\n");
            }
            return output.toString();
        } else {
                throw new IllegalArgumentException("No file is currently open.");
        }
    }
}
