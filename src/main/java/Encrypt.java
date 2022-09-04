import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//Encrypting and decrypting files
public class Encrypt {

    // secret KEY for encrypting
    private static final byte[] KEYVALUE = "6^)(9-p35@%3#4S!4S0)$Y%%^&5(j.&^&o(*0)$Y%!#O@*GpG@=+@j.&6^)(0-=+"
            .getBytes();
    static private final int BUFFERLEN = 1024;

    /**
     * method for encrypting files
     *
     * @param String oldFile  - source (path) file for encryption
     * @param String newFile - file (path) after encryption
     */
    public void encryptFile(String oldFile, String newFile) throws Exception {

        FileInputStream in = new FileInputStream(oldFile);
        File file = new File(newFile);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);

        //@param int size - number of bytes read in the buffer
        int size, position, keyLenght;
        position = 0;
        keyLenght = KEYVALUE.length;
        byte buffer[] = new byte[BUFFERLEN];
        while ((size = in.read(buffer)) != -1) {
            for (int i = 0; i < size; i++) {
                buffer[i] ^= KEYVALUE[position];
                out.write(buffer[i]);
                position++;
                if (position == keyLenght) {
                    position = 0;
                }
            }
        }
        in.close();
        out.close();
    }

    /**
     * method for decrypting files
     *
     * @param String oldFile  - source (path) file for decryption
     * @param String newFile - file (path) after decryption
     */
    public void decryptFile(String oldFile, String newFile) throws Exception {
        FileInputStream in = new FileInputStream(oldFile);
        File file = new File(newFile);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        int c, pos, keylen;
        pos = 0;
        keylen = KEYVALUE.length;
        byte buffer[] = new byte[BUFFERLEN];
        while ((c = in.read(buffer)) != -1) {
            for (int i = 0; i < c; i++) {
                buffer[i] ^= KEYVALUE[pos];
                out.write(buffer[i]);
                pos++;
                if (pos == keylen)
                    pos = 0;
            }
        }
        in.close();
        out.close();
    }
}

