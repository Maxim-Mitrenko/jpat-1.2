public class Logger {

    protected int num = 1;
    public static Logger logger;

    private Logger() {}

    public void log(String msg) {
        System.out.println("[" + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}