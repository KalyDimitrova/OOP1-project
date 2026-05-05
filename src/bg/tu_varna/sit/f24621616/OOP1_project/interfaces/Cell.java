package bg.tu_varna.sit.f24621616.OOP1_project.interfaces;

/**
 * Represents a cell in a spreadsheet table.
 * Each cell has a value and a string representation.
 */
public interface Cell {
    /**
     * Returns the numeric value of the cell.
     * Used for formula calculations.
     *
     * @return the value of the cell as a double
     */
    public double getValue();

    /**
     * Returns the display value of the cell for printing.
     * For formula cells returns the calculated result or "ERROR" if invalid.
     * For all other cells returns the same as toString().
     *
     * @return the display value of the cell as a String
     */
    String getDisplayValue();
}
