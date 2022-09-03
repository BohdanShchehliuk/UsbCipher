// we can encrypt and decrypt different type of file
public enum FileType {
    Doc(".doc"), Docx(".docx"), Xls(".xls"), Xlsx(".xlsx"), Txt(".txt");

    private final String typeOfFile;

    FileType(final String status) {
        this.typeOfFile = status;
    }

    public String getTypeOfFile() {
        return typeOfFile;
    }
}

