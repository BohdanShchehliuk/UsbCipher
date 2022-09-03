import java.io.File;

public class USBSearcher {

    int count = 0;
    int count1 = 0;

    public void findFiles(File folder) {

        // All files on the USB storage devices currently connected
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            count1++;
            if (file.isFile() && (file.getName().endsWith(FileType.Doc.getTypeOfFile()) ||
                    file.getName().endsWith(FileType.Docx.getTypeOfFile()))) {
                System.out.println(file);
                count++;
                Logic.listOfFileOfGivenTypes.add(file);

            } else if (!file.isFile()) {

                File folder0 = new File(file.getPath());
                findFiles(folder0);
            }
        }
    }

    public void findFilesOfGivenTypes(File[] listOfFiles) {

        for (File file : listOfFiles) {
            if (file.isFile() && (file.getName().endsWith(FileType.Doc.getTypeOfFile()) ||
                    file.getName().endsWith(FileType.Docx.getTypeOfFile()))) {
                Logic.listOfFileOfGivenTypes.add(file);
            }
        }
    }
}
