package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;

public class StringCell implements Cell {
    private String value;

    public StringCell(String value) {
        this.value = value;
    }


    @Override
    public double getValue() {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
