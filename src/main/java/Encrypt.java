import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Шифрование и дешифрование
 *
 * @author shaohl
 * @version 1.00
 */

public class Encrypt {

    // static boolean debug =false ;
    // Ключ шифрования не может быть изменен случайным образом
    static final byte[] KEYVALUE = "6^)(9-p35@%3#4S!4S0)$Y%%^&5(j.&^&o(*0)$Y%!#O@*GpG@=+@j.&6^)(0-=+"
            .getBytes();
    static final int BUFFERLEN = 1024;

    // Построить
    public Encrypt() {
    }

    /**
     * Шифровать файлы
     *
     * @param String
     * oldFile Исходный файл для шифрования
     * @param String
     * зашифрованный файл newFile
     * @return
     */
    public static void encryptFile(String oldFile, String newFile) throws Exception {

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

    /**
     * Расшифровывать файлы
     *
     * @param String
     * oldFile Исходный файл для расшифровки
     * @param String
     * Расшифрованный файл newFile
     * @return
     */
    public static void decryptFile(String oldFile, String newFile) throws Exception {
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

    /**
     * @param args
     */


}

