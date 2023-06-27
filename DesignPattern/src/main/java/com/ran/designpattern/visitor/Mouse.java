package com.ran.designpattern.visitor;

/**
 * Mouse
 *
 * @author rwei
 * @since 2023/6/27 18:02
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
