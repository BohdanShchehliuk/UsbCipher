import Exceptions.CustomException;
import lombok.extern.slf4j.Slf4j;
import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

@Slf4j
public class Logic {
    // For gathering all files of given types in one list
    public static List<File> listOfFilesOfGivenTypes = new ArrayList<>();
    public LocalDateTime date = LocalDateTime.now();

    // Mavon provide us library USBDeviceDetectorManager
    public USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager();
    // Collect all the USB storage devices currently connected
    public List<USBStorageDevice> usbStorageDeviceList = driveDetector.getRemovableDevices();

    public void searchAllFilesOfGivenTypes() throws CustomException {
        if (usbStorageDeviceList.isEmpty()) {
            throw new CustomException("Thre is no USB");
        }
        log.info("Searching all usb");

        for (USBStorageDevice usb : usbStorageDeviceList) {
            File folder = new File(usb.getRootDirectory().getPath());
            USBSearcher usbSearcher = new USBSearcher();
            log.info("Searching files of given type in usb");
            usbSearcher.findFiles(folder);
            if (listOfFilesOfGivenTypes.isEmpty()) {
                throw new CustomException("There is no file");
            }
        }
    }

    public void encryptAllFilesOfGivenType() throws Exception {
        File[] list = File.listRoots();
        File directoryEncrypt = new File(list[0].getPath() + "/Sipher/Encrypt/" +
                date.toLocalDate() + "/" +
                date.getNano());
        FileUtils.forceMkdir(directoryEncrypt);
        log.info("Folder for encrypted files was created");

        File directoryDecrypt = new File(list[0].getPath() + "/Sipher/Decrypt/" +
                date.toLocalDate() + "/" + date.getNano());
        FileUtils.forceMkdir(directoryDecrypt);
        log.info("Folder for decrypted files was created");

        // for best naming program puts count like prefix (to solve the problem if we have two files with same name)
        int count = 1;
        Encrypt encrypt = new Encrypt();
        log.info("Encrypting and decrypting is in process");
        for (File fileOfGivenType : listOfFilesOfGivenTypes) {
            String oldFile = fileOfGivenType.getPath();
            String encryptFile = directoryEncrypt + "/" + count + "__encr__" + fileOfGivenType.getName();
            String decryptFile = directoryDecrypt + "/" + count + "__decr__" + fileOfGivenType.getName();


            encrypt.encryptFile(oldFile, encryptFile);
            encrypt.decryptFile(encryptFile, decryptFile);
            count++;
        }
        log.info("Encrypting and decrypting where done. A total of <<" + (count-1) +">>" +
                " files were encrypted (as well as decrypted");
    }
}
