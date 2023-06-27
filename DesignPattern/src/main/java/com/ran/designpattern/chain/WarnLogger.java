package com.ran.designpattern.chain;

/**
 * WarnLogger
 *
 * @author rwei
 * @since 2023/6/26 22:01
 */
public class WarnLogger extends AbstractLogger {
    public WarnLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("WARN " + message);
    }
}
