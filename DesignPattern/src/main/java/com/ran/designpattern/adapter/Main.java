package com.ran.designpattern.adapter;

/**
 * Main
 * 适配器模式，将Turkey转换为Duck
 * @author rwei
 * @since 2023/6/18 21:19
 */
public class Main {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);
        turkeyAdapter.fly();
    }
}
