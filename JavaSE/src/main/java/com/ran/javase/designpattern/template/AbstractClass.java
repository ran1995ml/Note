package com.ran.javase.designpattern.template;

/**
 * AbstractClass
 * 模版方法模式
 * @author rwei
 * @since 2023/4/7 10:47
 */
public abstract class AbstractClass {
    //声明成final，以免子类改变算法顺序
    final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
    }

    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    void concreteOperation() {}
}
