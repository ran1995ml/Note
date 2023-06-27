package com.ran.designpattern.visitor;

/**
 * Visitor
 * 访问者接口
 * @author rwei
 * @since 2023/6/27 18:01
 */
public interface Visitor {
    public void visit(Computer computer);

    public void visit(Keyboard keyboard);

    public void visit(Mouse mouse);

    public void visit(Monitor monitor);
}
