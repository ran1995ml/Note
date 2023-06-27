package com.ran.designpattern.chain;

/**
 * ErrorLogger
 *
 * @author rwei
 * @since 2023/6/26 22:00
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR " + message);
    }
}
