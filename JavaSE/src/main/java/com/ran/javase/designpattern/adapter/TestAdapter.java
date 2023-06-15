package com.ran.javase.designpattern.adapter;

/**
 * TestAdapter
 * 适配器模式，将220V的电池通过适配器模式转换成5V的
 * @author rwei
 * @since 2023/3/10 17:50
 */
public class TestAdapter {
    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        V5Power v5Power = new V5PowerAdapter(new V220Power());
        mobile.inputPower(v5Power);
    }
}
