package com.ran.javase.designpattern.template;

/**
 * HRWorker
 *
 * @author rwei
 * @since 2023/3/14 09:52
 */
public class HRWorker extends Worker {

    public HRWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("find worker");
    }
}
