package com.ran.designpattern.interpreter;

/**
 * Expression
 * 表达式接口
 * @author rwei
 * @since 2023/6/27 13:55
 */
public interface Expression {
    public boolean interpret(String context);
}
