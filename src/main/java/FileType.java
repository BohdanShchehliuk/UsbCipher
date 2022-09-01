
public enum FileType {
    Doc(".doc"), Docx(".docx"), Xls(".xls"), Xlsx(".xlsx");

    private final String typeOfFile;

    FileType(final String status) {
        this.typeOfFile = status;
    }

    public String getTypeOfFile() {
        return typeOfFile;
    }
}

