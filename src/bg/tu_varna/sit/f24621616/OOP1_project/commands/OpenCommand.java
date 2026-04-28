package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.DoubleCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.FormulaCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.IntegerCell;
import bg.tu_varna.sit.f24621616.OOP1_project.cells.StringCell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;
import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Represents opening a file
 */
public class OpenCommand implements Command {
    /** The current state of the application. */
    private CurrentState state;
    /**The path of the file to open. */
    private String filePath;

    /**
     * Creates an OpenCommand with the given state and file.
     *
     * @param state the current state of the application
     * @param filePath the path of the file to open
     */
    public OpenCommand(CurrentState state, String filePath) {
        this.state = state;
        this.filePath = filePath;
    }

    /**
     * Opens a file and loads its contents into a new table.
     * If the file does not exist, creates a new empty file.
     * Throws an exception if a file is already open.
     * Throws an exception if an error occurs while reading the file.
     *
     * @return a success message with the opened file name
     */
    @Override
    public String execute() {
        if (state.isFileIsOpen()) {
            throw new IllegalArgumentException("A file is already open. Close it first.");
        }

        Table table = new Table();
        File file = new File(filePath);

        try {
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    int row = 0;
                    while ((line = reader.readLine()) != null) {
                        String[] cells = line.split(",");
                        for (int col = 0; col < cells.length; col++) {
                            Cell newCell;
                            String cellValue = cells[col].trim();
                            if (cellValue.isBlank()) {
                                continue;
                            } else if (cellValue.startsWith("\"")) {
                                newCell = new StringCell(cellValue);
                            } else if (cellValue.startsWith("=")) {
                                newCell = new FormulaCell(cellValue, table);
                            } else if (cellValue.contains(".")) {
                                newCell = new DoubleCell(Double.parseDouble(cellValue));
                            } else {
                                newCell = new IntegerCell(Integer.parseInt(cellValue));
                            }
                            table.setCell(row, col, newCell);
                        }
                        row++;
                    }
                }
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error opening file: " + e.getMessage());
        }
        state.setCurrentTable(table);
        state.setFilePath(filePath);
        state.setFileIsOpen(true);
        return "Successfully opened " + filePath;
    }
}
