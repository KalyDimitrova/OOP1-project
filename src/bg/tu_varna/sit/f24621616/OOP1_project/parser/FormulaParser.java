package bg.tu_varna.sit.f24621616.OOP1_project.parser;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a utility for parsing formulas and extracting needed cells.
 */
public class FormulaParser {
    /**
     * Parses a formula string and returns a list of cells referenced in it.
     * Only cells that exist in the table are included in the result.
     *
     * @param formula the formula string starting with '='
     * @param table the table to look up cell references from
     * @return a list of cells referenced in the formula
     */
    public static List<Cell> getNeededCells(String formula, Table table) {
        List<Cell> neededCells = new ArrayList<>();
        String[] tokens = formula.substring(1).trim().split(" ");

        for (String token : tokens) {
            if (token.matches("R\\d+C\\d+")) {
                int row = Integer.parseInt(token.substring(1, token.indexOf('C'))) - 1;
                int col = Integer.parseInt(token.substring(token.indexOf('C') + 1)) - 1;

                Cell cell = table.getCell(row, col);
                if (cell != null) {
                    neededCells.add(cell);
                }
            }
        }
        return neededCells;
    }
}
