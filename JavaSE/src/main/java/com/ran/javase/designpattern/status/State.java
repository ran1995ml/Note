package com.ran.javase.designpattern.status;

/**
 * State
 *
 * @author rwei
 * @since 2023/3/14 11:20
 */
public interface State {
    public void insertMoney();

    public void backMoney();

    public void turnCrank();

    public void dispense();
}
