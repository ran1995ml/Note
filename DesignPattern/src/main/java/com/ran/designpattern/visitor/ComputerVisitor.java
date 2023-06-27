package com.ran.designpattern.visitor;

/**
 * ComputerVisitor
 *
 * @author rwei
 * @since 2023/6/27 18:45
 */
public class ComputerVisitor implements Visitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Display computer");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Display keyboard");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Display mouse");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Display monitor");
    }
}
