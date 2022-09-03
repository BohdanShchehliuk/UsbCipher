import java.io.File;

//provide searching files not only in root but in all folders in USB
public class USBSearcher {

    /*recursion method provide searching all Doc and Docx files. If you want search another type of files,
    please  use enum FileType and change cod
     */
    public void findFiles(File folder) {

        // All files on the USB storage device currently connected
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && (file.getName().endsWith(FileType.Doc.getTypeOfFile()) ||
                    file.getName().endsWith(FileType.Docx.getTypeOfFile()))) {
                Logic.listOfFilesOfGivenTypes.add(file);
            } else if (!file.isFile()) {
                File folderNew = new File(file.getPath());
                findFiles(folderNew);
            }
        }
    }
}
