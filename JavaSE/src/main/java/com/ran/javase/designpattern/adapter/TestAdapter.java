package com.ran.javase.designpattern.adapter;

/**
 * TestAdapter
 *
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
