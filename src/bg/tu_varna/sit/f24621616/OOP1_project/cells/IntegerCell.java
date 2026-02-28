package bg.tu_varna.sit.f24621616.OOP1_project.cells;

import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;

public class IntegerCell implements Cell {
    private int value;

    public IntegerCell(int value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
