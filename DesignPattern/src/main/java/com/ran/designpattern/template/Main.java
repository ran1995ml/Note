package com.ran.designpattern.template;

/**
 * Main
 * 模板方法模式
 * @author rwei
 * @since 2023/6/19 19:22
 */
public class Main {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();

        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
