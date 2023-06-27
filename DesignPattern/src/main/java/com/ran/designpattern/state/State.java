package com.ran.designpattern.state;

/**
 * State
 *
 * @author rwei
 * @since 2023/6/21 11:29
 */
public interface State {
    public void insertQuarter();

    public void ejectQuarter();

    public void turnCrank();

    public void dispense();
}
