UsbCipher
The project involves searching for files of a given type from flash drives inserted into the computer, their ** encryption and decryption**.

By default, the program works with ".doc" and ".docx" files. To work with files of other types (for example, ".txt"), you can use enum.

The program is tested to work on Windows systems but its mechanisms are also suitable for other operating systems OS.

UsbSearcher
The class is designed to find files of a given type

Encrypt
The class is designed for encoding and decoding files. Key elements:

static final byte[]KEYVALUE;
        void encryptFile(String oldFile,String newFile);
        void decryptFile(String oldFile,String newFile);
FileTypeEnum
Enum in which the extension of the files with which the program works is provided

DaemonThread
Class DaemonThread designed for the program to work in the background Starts an instance of the Logic class

Logic
Logic class is responsible for the sequence of program execution

Creating a list of flash drives connected to the computer: usbStorageDeviceList
Searching for files of a given type in flash drives (including all folders) void searchAllFilesOfGivenTypes() and forming a list of all files of a given type listOfFilesOfGivenTypes
Encryption and decryption of files of a given type encryptAllFilesOfGivenType()
Creating folders on the first drive (drive "C") for encryption and decryption
Encryption and decryption of files along with assigning them new names
Main
Assigns the daemon status to the thread and starts the program

Test
The program has created a test that checks the correct encryption and decryption of the file: ТестOrigin.docx

USB Drive Detector
when searching for USB programs using the library USB Drive Detector
