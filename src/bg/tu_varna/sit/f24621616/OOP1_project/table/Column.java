package bg.tu_varna.sit.f24621616.OOP1_project.table;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a column in the table.
 */
public class Column {
    /** The index of the current column. */
    private int index;
    /** A list of cells in the said column. */
    private List<Cell> cells = new ArrayList<>();

    /**
     * Creates a column with the given index.
     *
     * @param index the index of the current column
     */
    public Column(int index) {
        this.index = index;
    }

    /**
     * Returns the index of the current column.
     *
     * @return index of current column
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the amount of cells in the current column.
     *
     * @return the size of the cells List
     */
    public int getSize() {
        return cells.size();
    }

    /**
     * Checks if the row exists and returns the cells in it.
     * Return null if the row is out of the table.
     *
     * @param row the index of the row in search
     * @return the cells in that row
     */
    public Cell getCell(int row) {
        if (row < cells.size()) {
            return cells.get(row);
        }
        return null;
    }

    /**
     * Expands the rows until the given row index.
     * Sets null value in all cells that were outside the table.
     * Sets the cell in the row of the given index with the given cell type.
     *
     * @param row the index of the row to fill
     * @param cell the cell type, with its values, to set in the row
     */
    public void setCell(int row, Cell cell) {
        while (cells.size() <= row) {
            cells.add(null);
        }
        cells.set(row, cell);
    }
}
