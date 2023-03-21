package com.ran.javase.designpattern.status;

/**
 * VendingMachine
 * 状态设计模式：自动贩卖机场景
 * 包含已投币、售出商品、未投币、商品售罄等状态
 * 状态变化需要对应的方法
 * 思路1：类中实现多个方法，每个方法case when当前的状态，做状态的切换
 * 但如果增加状态，需要在case when中添加新的判断条件，容易出错
 * 思路2：使用状态设计模式，将每个状态抽象成接口，如果状态不变，增加动作，可把动作也抽象出来，达到最大的扩展
 * @author rwei
 * @since 2023/3/14 11:13
 */
public class VendingMachine {
    private State noMoneyState;

    private State hasMoneyState;

    private State soldState;

    private State soldOutState;

    private State winnerState;

    private int count;

    private State currentState = noMoneyState;

    public VendingMachine(int count) {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);
        if (count > 0) {
            this.count = count;
            currentState = noMoneyState;
        }
    }

    public void insertMoney() {
        currentState.insertMoney();
    }

    public void backMoney() {
        currentState.backMoney();
    }

    public void turnCrank() {
        currentState.turnCrank();
    }

    public void setState(State state) {
        this.currentState = state;
    }
}
