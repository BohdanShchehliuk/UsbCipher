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
            USBSearcher usbSearcher = new USBSearcher();
            USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager();
            // Display all the USB storage devices currently connected
            List<USBStorageDevice> usbStorageDeviceList = driveDetector.getRemovableDevices();
            File folder = new File(usbStorageDeviceList.get(0).getRootDirectory().getPath());
            usbSearcher.findFiles(folder);
            System.out.println(usbSearcher.count);
            System.out.println(usbSearcher.count1);

            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}