package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

/**
 * Represents a cell containing a formula as its value.
 */
public class FormulaCell implements Cell {
    private String formula;
    private Table table;

    /**
     * Creates a FormulaCell with the given formula and table.
     *
     * @param formula the formula string starting with '='
     * @param table the table used to look up cell references
     */
    public FormulaCell(String formula, Table table) {
        this.formula = formula;
        this.table = table;
    }

    /**
     * Resolves a token to its numeric value.
     * If the token is a cell reference (e.g. R1C1), looks it up in the table.
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

            Cell cell = table.getCell(row, col);
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
    @Override
    public String toString() {
        try {
            return String.valueOf(getValue());
        } catch (Exception e) {
            return "ERROR";
        }
    }
}
