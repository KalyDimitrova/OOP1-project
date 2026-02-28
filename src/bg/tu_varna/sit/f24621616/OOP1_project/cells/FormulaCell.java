package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

public class FormulaCell implements Cell {
    private String formula;
    private Table table;

    public FormulaCell(String formula, Table table) {
        this.formula = formula;
        this.table = table;
    }

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

    @Override
    public String toString() {
        try {
            return String.valueOf(getValue());
        } catch (Exception e) {
            return "ERROR";
        }
    }
}
