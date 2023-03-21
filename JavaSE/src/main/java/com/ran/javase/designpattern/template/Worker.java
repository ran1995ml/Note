package com.ran.javase.designpattern.template;

/**
 * Worker
 * 定义超类，作为算法骨架
 * @author rwei
 * @since 2023/3/13 18:21
 */
public abstract class Worker {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    public final void workOneDay() {
        enterCompany();
        work();
        exitCompany();
    }

    public abstract void work();

    public void enterCompany() {
        System.out.println("enter company");
    }

    public void exitCompany() {
        System.out.println("exit company");
    }

    //钩子方法
    public boolean isNeedPrintData() {
        return false;
    }
}
