package bg.tu_varna.sit.f24621616.OOP1_project.table;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a row in the table.
 */
public class Row {
    /** The index of the current row. */
    private int index;
    /** A list of cells in the said row. */
    private List<Cell> cells = new ArrayList<>();

    /**
     * Creates a row with the given index.
     *
     * @param index the index of the current row
     */
    public Row(int index) {
        this.index = index;
    }

    /**
     * Returns the index of the current row.
     *
     * @return index of current row
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the amount of cells in the current row.
     *
     * @return the size of the cells List
     */
    public int getSize() {
        return cells.size();
    }

    /**
     * Checks if the column exists and returns the cells in it.
     * Return null if the column is out of the table.
     *
     * @param col the index of the column in search
     * @return the cells in that column
     */
    public Cell getCell(int col) {
        if (col < cells.size()) {
            return cells.get(col);
        }
        return null;
    }

    /**
     * Expands the columns until the given column index.
     * Sets null value in all cells that were outside the table.
     * Sets the cell in the column of the given index with the given cell type.
     *
     * @param col the index of the column to fill
     * @param cell the cell type, with its values, to set in the column
     */
    public void setCell(int col, Cell cell) {
        while (cells.size() <= col) {
            cells.add(null);
        }
        cells.set(col, cell);
    }
}
