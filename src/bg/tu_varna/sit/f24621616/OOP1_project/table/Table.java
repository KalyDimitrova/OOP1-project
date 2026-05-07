package bg.tu_varna.sit.f24621616.OOP1_project.table;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a spreadsheet table containing rows and columns of cells.
 */
public class Table {
    /** A list of rows in the table. */
    private List<Row> rows;
    /** A list of columns in the table. */
    private List<Column> columns;
    /**
     * Creates an empty Table with no rows or columns.
     */
    public Table() {
        rows = new ArrayList<>();
        columns = new ArrayList<>();
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
        if (row < rows.size()) {
            return rows.get(row).getCell(col);
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
        while (rows.size() <= row) {
            rows.add(new Row(rows.size()));
        }

        while (columns.size() <= col) {
            columns.add(new Column(columns.size()));
        }

        rows.get(row).setCell(col, cell);
        columns.get(col).setCell(row, cell);
    }

    /**
     * Returns the number of rows in the table.
     *
     * @return the number of rows
     */
    public int getRowCount() {
        return rows.size();
    }

    /**
     * Returns the number of columns in the table.
     *
     * @return the number of columns
     */
    public int getColumnCount() {
        return columns.size();
    }
}
