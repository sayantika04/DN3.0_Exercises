public class Logger {
    // Private static instance of the Logger class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize the logger (if needed)
    }

    // Public static method to get the single instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using both logger instances
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Check if both logger instances are the same
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("logger1 and logger2 refer to different instances.");
        }
    }
}
