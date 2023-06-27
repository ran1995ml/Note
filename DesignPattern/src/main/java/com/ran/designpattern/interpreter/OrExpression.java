package com.ran.designpattern.interpreter;

/**
 * OrExpression
 *
 * @author rwei
 * @since 2023/6/27 15:04
 */
public class OrExpression implements Expression {
    private Expression expr1;

    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
