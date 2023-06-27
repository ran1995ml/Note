package com.ran.designpattern.facade;

/**
 * HomeTheaterFacade
 *
 * @author rwei
 * @since 2023/6/18 21:39
 */
public class HomeTheaterFacade {
    private CdPlayer cdPlayer;

    private Screen screen;

    public HomeTheaterFacade(CdPlayer cdPlayer, Screen screen) {
        this.cdPlayer = cdPlayer;
        this.screen = screen;
    }

    public void watchMovie() {
        cdPlayer.on();
        screen.on();
    }

    public void endMovie() {
        cdPlayer.off();
        screen.off();
    }
}
