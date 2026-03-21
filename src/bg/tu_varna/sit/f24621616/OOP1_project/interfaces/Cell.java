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
}
