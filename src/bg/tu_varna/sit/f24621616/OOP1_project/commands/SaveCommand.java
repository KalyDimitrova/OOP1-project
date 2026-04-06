package bg.tu_varna.sit.f24621616.OOP1_project.commands;

import bg.tu_varna.sit.f24621616.OOP1_project.app.CurrentState;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Cell;
import bg.tu_varna.sit.f24621616.OOP1_project.interfaces.Command;
import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Represents saving the contents of the file in the same place.
 */
public class SaveCommand implements Command {
    private CurrentState state;

    /**
     * Creates a SaveCommand with given application state.
     *
     * @param state the current state of the application
     */
    public SaveCommand(CurrentState state) {
        this.state = state;
    }

    /**
     * Saves the current table to the currently open file.
     * Throws an exception if no file is currently open.
     * Throws an exception if an error occurs while writing to the file.
     *
     * @return a success message with the saved file name
     */
    @Override
    public String execute() {
        if (state.isFileIsOpen()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(state.getFilePath()))) {
                Table table = state.getCurrentTable();
                for (int i = 0; i < table.getRowCount(); i++) {
                    StringBuilder row = new StringBuilder();
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        Cell cell = table.getCell(i, j);
                        if (j > 0) row.append(", ");
                        if (cell != null) row.append(cell.toString());
                    }
                    writer.println(row.toString());
                }
            } catch (IOException e) {
                throw new RuntimeException("Error saving file: " + e.getMessage());
            }
            return "Successfully saved " + state.getFilePath();
        } else {
            throw new IllegalArgumentException("No file is currently open.");
        }
    }
}
