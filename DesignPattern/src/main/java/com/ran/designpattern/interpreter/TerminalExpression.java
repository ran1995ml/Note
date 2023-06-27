package com.ran.designpattern.interpreter;

/**
 * TerminalExpression
 *
 * @author rwei
 * @since 2023/6/27 13:57
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
