package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;

/**
 * Represents a cell containing a Double value.
 */
public class DoubleCell implements Cell {
    /** The value stored in the cell. */
    private double value;

    /**
     * Creates a DoubleCell with the given value.
     *
     * @param value the double value of the cell
     */
    public DoubleCell(double value) {
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
     * Returns the double value as a String.
     *
     * @return the double value of the cell as a String
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
