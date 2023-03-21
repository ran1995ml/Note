package com.ran.javase.designpattern.template;

/**
 * ITWorker
 *
 * @author rwei
 * @since 2023/3/14 09:50
 */
public class ITWorker extends Worker {

    public ITWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("fix bug");
    }

    @Override
    public boolean isNeedPrintData() {
        return true;
    }
}
