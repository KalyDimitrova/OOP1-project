package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.contracts.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a cell containing a formula as its value.
 */
public class FormulaCell extends Cell {
    /** The formula string starting with '='. */
    private String formula;
    // Provide only the cells needed for the formula.
    /** The list of cells needed for the formula. */
    private List<Cell> cells;

    /**
     * Creates a FormulaCell with the given formula and table.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param formula the formula string starting with '='
     * @param cells the list of cells needed for the formula
     */
    public FormulaCell(int row, int col, String formula, List<Cell> cells) {
        super(row, col);
        this.formula = formula;
        this.cells = cells;
    }

    /**
     * Resolves a token to its numeric value.
     * If the token is a cell reference (e.g. R1C1), searches the cells list for it.
     * Otherwise, parses it as a double.
     *
     * @param token the token to resolve
     * @return the numeric value of the token as a double
     */
    // helper method to get the value of a cell
    private double getTokenValue(String token) {
        if (token.matches("R\\d+C\\d+")) {
            int row = Integer.parseInt(token.substring(1, token.indexOf('C'))) - 1;
            int col = Integer.parseInt(token.substring(token.indexOf('C') + 1)) - 1;

            Cell cell = findCell(row, col);
            if (cell == null) return 0;
            return cell.getValue();
        } else {
            try {
                return Double.parseDouble(token);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

    /**
     * Searches the list of cells for a cell at the given row and column.
     * Adds 1 to row and col to convert from 0-based to 1-based indices.
     * Returns null if no cell is found at the given position.
     *
     * @param row the row index to search for
     * @param col the column index to search for
     * @return the cell at the given position, or null if not found
     */
    // helper method to find the needed cell for the calculations.
    private Cell findCell(int row, int col) {
        for (Cell cell : cells) {
            // + 1 because the table is not 0-based
            if (cell.getRow() == row + 1 && cell.getCol() == col + 1) {
                return cell;
            }
        }
        return null;
    }

    /**
     * Parses and evaluates the formula.
     * Supports addition, subtraction, multiplication and division.
     * Cell references (e.g. R1C1) are looked up in the table.
     *
     * @return the result of the formula as a double
     */
    @Override
    public double getValue() {
        String expression = formula.substring(1).trim();
        String[] tokens = expression.split(" ");

        double result = 0.0;
        String operator = "+";

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                operator = token;
            } else {
                double value = getTokenValue(token);
                switch (operator) {
                    case "+": result += value; break;
                    case "-": result -= value; break;
                    case "*": result *= value; break;
                    case "/": result /= value; break;
                }
            }
        }
        return result;
    }

    /**
     * Returns the result of the formula as a String.
     * Returns "ERROR" if the formula cannot be evaluated (e.g. division by zero).
     *
     * @return the result of the formula as a String, or "ERROR" if invalid
     */
    public String getDisplayValue() {
        try {
            double result = getValue();
            if (Double.isInfinite(result) || Double.isNaN(result)) {
                return "ERROR";
            }

            return String.valueOf(result);
        } catch (Exception e) {
            return "ERROR";
        }
    }

    /**
     * Returns the formula string as stored in the cell.
     *
     * @return the formula string
     */
    @Override
    public String toString() {
        return formula;
    }
}
