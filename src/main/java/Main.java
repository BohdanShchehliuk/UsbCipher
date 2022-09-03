import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Thread dt = new Thread(new DaemonThread());
        dt.setDaemon(true);
        dt.run();
    }
}
