package com.ran.designpattern.chain;

/**
 * ConsoleLogger
 *
 * @author rwei
 * @since 2023/6/26 21:58
 */
public class InfoLogger extends AbstractLogger {
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO " + message);
    }
}
