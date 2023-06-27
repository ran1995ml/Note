package com.ran.designpattern.visitor;

/**
 * Computer
 *
 * @author rwei
 * @since 2023/6/27 18:01
 */
public class Computer implements ComputerPart{
    private ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(visitor);
        }
        visitor.visit(this);
    }
}
