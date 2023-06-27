package com.ran.designpattern.facade;

/**
 * Main
 * 外观模式，提供一个简化接口
 * @author rwei
 * @since 2023/6/18 21:44
 */
public class Main {
    public static void main(String[] args) {
        CdPlayer cdPlayer = new CdPlayer();
        Screen screen = new Screen();
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(cdPlayer, screen);
        homeTheaterFacade.watchMovie();
        homeTheaterFacade.endMovie();
    }
}
