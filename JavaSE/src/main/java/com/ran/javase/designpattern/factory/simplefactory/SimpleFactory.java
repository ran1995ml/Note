package com.ran.javase.designpattern.factory.simplefactory;

import com.ran.javase.designpattern.factory.Bean;
import com.ran.javase.designpattern.factory.BeanA;
import com.ran.javase.designpattern.factory.BeanB;
import com.ran.javase.designpattern.factory.BeanC;

/**
 * SimpleFactory
 * 简单工厂模式
 * @author rwei
 * @since 2023/2/22 15:49
 */
public class SimpleFactory {
    public Bean createBean(String type) {
        if (type == "A") {
            return new BeanA();
        } else if (type == "B") {
            return new BeanB();
        } else {
            return new BeanC();
        }
    }
}
