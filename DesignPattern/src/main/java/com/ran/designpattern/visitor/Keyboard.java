package com.ran.designpattern.visitor;

/**
 * Keyboard
 *
 * @author rwei
 * @since 2023/6/27 18:02
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
