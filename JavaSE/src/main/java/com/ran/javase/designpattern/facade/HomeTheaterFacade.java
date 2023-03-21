package com.ran.javase.designpattern.facade;

/**
 * HomeTheaterFacade
 * 外观设计模式，提供一个访问所有子系统的所有接口
 * 场景：看电影，包括打开电脑，开启播放器等步骤，将这些功能统一在一个接口里实现
 * @author rwei
 * @since 2023/3/13 18:15
 */
public class HomeTheaterFacade {
    private Computer computer;

    private Player player;

    public HomeTheaterFacade(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void watchMovie() {
        this.computer.open();
        this.player.open();
    }

    public void closeMovie() {
        this.player.close();
        this.computer.close();
    }
}
