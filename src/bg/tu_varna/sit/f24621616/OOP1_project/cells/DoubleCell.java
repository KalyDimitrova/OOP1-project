package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;

/**
 * Represents a cell containing a Double value.
 */
public class DoubleCell extends Cell {
    /** The value stored in the cell. */
    private double value;

    /**
     * Creates a DoubleCell with the given value.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the double value of the cell
     */
    public DoubleCell(int row, int col, double value) {
        super(row, col);
        this.value = value;
    }

    /**
     * Returns the double value.
     *
     * @return the double value of the cell
     */
    @Override
    public double getValue() {
        return value;
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
     * Returns the double value as a String.
     *
     * @return the double value of the cell as a String
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
