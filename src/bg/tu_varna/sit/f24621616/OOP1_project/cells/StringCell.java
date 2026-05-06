package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;

/**
 * Represents a cell containing a String value.
 */
public class StringCell extends Cell {
    /** The value stored in the cell. */
    private String value;

    /**
     * Creates a StringCell with the given value.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the String value of the cell
     */
    public StringCell(int row, int col, String value) {
        super(row, col);
        this.value = value;
    }

    /**
     * Returns the String value as a double.
     * If the string contains only digits, returns it as an integer.
     * If the string contains digits and a dot, returns it as a double.
     * Otherwise, returns 0.
     *
     * @return the numeric value of the cell as a double
     */
    @Override
    public double getValue() {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
    }

    /**
     * Returns the value of the cell as a String for display.
     *
     * @return the value of the cell as a String
     */
    @Override
    public String getDisplayValue() {
        return toString();
    }

    /**
     * Returns the String value.
     *
     * @return the String value of the cell
     */
    @Override
    public String toString() {
        return value;
    }
}
