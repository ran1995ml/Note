package com.ran.designpattern.visitor;

/**
 * ComputerPart
 * 元素接口
 * @author rwei
 * @since 2023/6/27 18:00
 */
public interface ComputerPart {
    public void accept(Visitor visitor);
}
