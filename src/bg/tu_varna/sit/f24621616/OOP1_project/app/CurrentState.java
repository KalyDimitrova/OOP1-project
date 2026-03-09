package bg.tu_varna.sit.f24621616.OOP1_project.app;

import bg.tu_varna.sit.f24621616.OOP1_project.table.Table;

public class CurrentState {
    private Table currentTable;
    private String filePath;
    private boolean fileIsOpen;

    public Table getCurrentTable() {
        return currentTable;
    }

    public void setCurrentTable(Table currentTable) {
        this.currentTable = currentTable;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isFileIsOpen() {
        return fileIsOpen;
    }

    public void setFileIsOpen(boolean fileIsOpen) {
        this.fileIsOpen = fileIsOpen;
    }
}
