package bg.tu_varna.sit.f24621616.OOP1_project.contracts;

/**
 * Represents a cell in a spreadsheet table.
 * Each cell has a value and a string representation.
 */
public abstract class Cell {
    /** The row index of the cell (1-based). */
    private int row;

    /** The column index of the cell (1-based). */
    private int col;

    /**
     * Creates a Cell with the given row and column position.
     *
     * @param row the row index of the cell (1-based)
     * @param col the column index of the cell (1-based)
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row index of the cell.
     *
     * @return the row index of the cell
     */
    public int getRow() { return row; }

    /**
     * Returns the column index of the cell.
     *
     * @return the column index of the cell
     */
    public int getCol() { return col; }

    /**
     * Returns the numeric value of the cell.
     * Used for formula calculations.
     *
     * @return the value of the cell as a double
     */
    public abstract double getValue();

    /**
     * Returns the display value of the cell for printing.
     * For formula cells returns the calculated result or "ERROR" if invalid.
     * For all other cells returns the same as toString().
     *
     * @return the display value of the cell as a String
     */
    public abstract String getDisplayValue();
}
