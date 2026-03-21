package bg.tu_varna.sit.f24621616.OOP1_project.table;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a spreadsheet table containing rows and columns of cells.
 */
public class Table {
    private List<List<Cell>> cells;
    /**
     * Creates an empty Table with no rows or columns.
     */
    public Table() {
        cells = new ArrayList<>();
    }

    /**
     * Returns the cell at the given row and column.
     * Returns null if the cell does not exist.
     *
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     * @return the cell at the given position, or null if it does not exist
     */
    public Cell getCell(int row, int col) {
        if (row < cells.size() && col < cells.get(row).size()) {
            return cells.get(row).get(col);
        }
        return null;
    }

    /**
     * Sets the cell at the given row and column.
     * Expands the table if necessary.
     *
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     * @param cell the cell to set
     */
    public void setCell(int row, int col, Cell cell) {
        while (cells.size() <= row) {
            cells.add(new ArrayList<>());
        }
        List<Cell> rowCells = cells.get(row);

        while (rowCells.size() <= col) {
            rowCells.add(null);
        }
        rowCells.set(col, cell);
    }

    /**
     * Returns the number of rows in the table.
     *
     * @return the number of rows
     */
    public int getRowCount() {
        return cells.size();
    }

    /**
     * Returns the number of columns in the table.
     * Returns the size of the longest row.
     *
     * @return the number of columns
     */
    public int getColumnCount() {
        int maxColumns = 0;
        for (List<Cell> row : cells) {
            if (row.size() > maxColumns) {
                maxColumns = row.size();
            }
        }
        return maxColumns;
    }
}
