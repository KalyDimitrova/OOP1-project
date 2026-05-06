package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;

/**
 * Represents a cell containing an Integer value.
 */
public class IntegerCell extends Cell {
    /** The value stored in the cell. */
    private int value;

    /**
     * Creates an IntegerCell with the given value.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the integer value of the cell
     */
    public IntegerCell(int row, int col, int value) {
        super(row, col);
        this.value = value;
    }

    /**
     * Returns the integer value as a double.
     *
     * @return the integer value of the cell as a double
     */
    @Override
    public double getValue() {
        return this.value;
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
     * Returns the integer value as a String.
     *
     * @return the integer value of the cell as a String
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
