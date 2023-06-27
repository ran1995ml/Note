package com.ran.designpattern.chain;

/**
 * Main
 * 责任链模式
 * @author rwei
 * @since 2023/6/26 22:02
 */
public class Main {
    public static void main(String[] args) {
        AbstractLogger logger = getLogger();
        logger.logMessage(AbstractLogger.INFO, "info");
        logger.logMessage(AbstractLogger.DEBUG, "debug");
        logger.logMessage(AbstractLogger.ERROR, "error");

    }

    public static AbstractLogger getLogger() {
        InfoLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        WarnLogger warnLogger = new WarnLogger(AbstractLogger.DEBUG);
        ErrorLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        errorLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(infoLogger);
        return errorLogger;
    }
}
