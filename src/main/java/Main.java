public class Main {

    public static void main(String[] args) {
        Thread dt = new Thread(new DaemonThread());
        dt.setDaemon(true);
        dt.run();
    }
}
