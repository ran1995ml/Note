package com.ran.javase.designpattern.adapter;

/**
 * V5PowerAdapter
 * 适配器模式，场景：220V的电源转换成5V的电源
 * @author rwei
 * @since 2023/3/10 17:46
 */
public class V5PowerAdapter implements V5Power {

    private V220Power v220Power;

    public V5PowerAdapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    @Override
    public int provideV5Power() {
        int power = v220Power.provideV220Power();
        System.out.println("V220->V5");
        power = 5;
        return power;
    }
}
