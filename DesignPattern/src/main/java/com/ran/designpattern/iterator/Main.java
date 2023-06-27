package com.ran.designpattern.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * Main
 * 迭代器模式
 * 两种菜单的遍历方式不同，用迭代器封装遍历过程
 * @author rwei
 * @since 2023/6/20 13:35
 */
public class Main {
    public static void main(String[] args) {
        Menu breakfastMenu = new BreakfastMenu();
        Menu dinnerMenu = new DinnerMenu();
        List<Menu> menus = Arrays.asList(breakfastMenu, dinnerMenu);
        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }
}
