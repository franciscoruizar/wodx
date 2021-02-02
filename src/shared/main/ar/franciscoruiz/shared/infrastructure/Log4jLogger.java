package ar.franciscoruiz.shared.infrastructure;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import org.apache.logging.log4j.LogManager;

import java.io.Serializable;
import java.util.HashMap;

@Service
public final class Log4jLogger implements Logger {
    org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log4jLogger.class);

    @Override
    public void info(String $message) {
        logger.info($message);
    }

    @Override
    public void info(String $message, HashMap<String, Serializable> $context) {
        logger.info($message, $context);
    }

    @Override
    public void warning(String $message) {
        logger.warn($message);
    }

    @Override
    public void warning(String $message, HashMap<String, Serializable> $context) {
        logger.warn($message, $context);
    }

    @Override
    public void critical(String $message) {
        logger.error($message);
    }

    @Override
    public void critical(String $message, HashMap<String, Serializable> $context) {
        logger.error($message, $context);
    }
}
