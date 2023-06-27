package com.ran.designpattern.interpreter;

/**
 * Main
 * 解释器模式
 * @author rwei
 * @since 2023/6/27 15:16
 */
public class Main {
    public static void main(String[] args) {
        Expression expression = getExpression();
        System.out.println(expression.interpret("John is male"));
    }

    //Robert和John是男性
    public static Expression getExpression() {
        return new OrExpression(new TerminalExpression("John"), new TerminalExpression("Robert"));
    }
}
