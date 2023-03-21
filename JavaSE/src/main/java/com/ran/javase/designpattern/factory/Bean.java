package com.ran.javase.designpattern.factory;

/**
 * Bean
 *
 * @author rwei
 * @since 2023/2/22 15:41
 */
public abstract class Bean {
    protected String name;

    public void printName() {
        System.out.println(name);
    }
}
