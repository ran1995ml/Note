package com.ran.designpattern.visitor;

/**
 * Monitor
 *
 * @author rwei
 * @since 2023/6/27 18:02
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
