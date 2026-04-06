package bg.tu_varna.sit.f24621616.OOP1_project.app;

import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

/**
 * Represents the current state of the application.
 */
public class CurrentState {
    private Table currentTable;
    private String filePath;
    private boolean fileIsOpen;

    /**
     * Returns the current table loaded in memory.
     *
     * @return the current table
     */
    public Table getCurrentTable() {
        return currentTable;
    }

    /**
     * Sets the current table to the given table.
     *
     * @param currentTable the value to be set as the current table
     */
    public void setCurrentTable(Table currentTable) {
        this.currentTable = currentTable;
    }

    /**
     * Returns the path of the file where the current table is stored.
     *
     * @return the file path where the table is stored
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path as the given value.
     *
     * @param filePath the value to be set as the current file path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Check if a file is already open.
     *
     * @return true if yes, false if no
     */
    public boolean isFileIsOpen() {
        return fileIsOpen;
    }

    /**
     * Sets whether a file is currently open.
     *
     * @param fileIsOpen updates the current value with the new one
     */
    public void setFileIsOpen(boolean fileIsOpen) {
        this.fileIsOpen = fileIsOpen;
    }
}
