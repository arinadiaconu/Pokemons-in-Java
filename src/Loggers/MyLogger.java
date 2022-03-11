package Loggers;

import java.util.logging.Logger;

public class MyLogger {
    public Logger logger;

    public MyLogger() {
        this.logger = Logger.getLogger("MyLogger");
        this.logger.info("Your logger is ready!");
    }
}
