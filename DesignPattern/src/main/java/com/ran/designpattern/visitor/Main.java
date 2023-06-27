package com.ran.designpattern.visitor;

/**
 * Main
 * 访问者模式，元素的算法根据访问者不同而改变
 * @author rwei
 * @since 2023/6/27 18:47
 */
public class Main {
    public static void main(String[] args) {
        ComputerPart computerPart = new Computer();
        computerPart.accept(new ComputerVisitor());
    }
}
