package bg.tu_varna.sit.f24621616.OOP1_project.table;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<List<Cell>> cells;

    public Table() {
        cells = new ArrayList<>();
    }

    public Cell getCell(int row, int col) {
        if (row < cells.size() && col < cells.get(row).size()) {
            return cells.get(row).get(col);
        }
        return null;
    }

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

    public int getRowCount() {
        return cells.size();
    }

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
