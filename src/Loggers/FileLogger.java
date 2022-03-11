package Loggers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
    public Logger logger;
    FileHandler fh;

    public FileLogger(String pathToFile) {
        logger = Logger.getLogger("MyLogger");

        try {
            // This block configures the logger with handler and formatter
            fh = new FileHandler(pathToFile);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // removes the console handler
            logger.setUseParentHandlers(false);

            // the following statement is used to log any messages
            logger.info("Your FileLogger is ready!");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
