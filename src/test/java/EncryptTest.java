import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

class EncryptTest {

//  to be sure test working correctly please put absolute path on:
//  @String originFil,  @String encryptedFile,  @String decryptedFile
//  this params is located on srs/test/java/resoursesForTest on this program

    @Test
    void encryptFile() throws Exception {
        String originFile = "resoursesForTest/TestOrigin.docx";
        String encryptedFile = "resoursesForTest/TestEncrypt.docx";
        String decryptedFile = "resoursesForTest/TestDecrypt.docx";
        Encrypt encrypt = new Encrypt();
        encrypt.encryptFile(originFile, encryptedFile);
        encrypt.decryptFile(encryptedFile, decryptedFile);
        File orig = new File(originFile);
        File encr = new File(encryptedFile);
        File decr = new File(decryptedFile);
        boolean trueOne = FileUtils.contentEquals(orig, decr);
        boolean falseOne = FileUtils.contentEquals(orig, encr);
        assertEquals(trueOne, !falseOne);
    }
}