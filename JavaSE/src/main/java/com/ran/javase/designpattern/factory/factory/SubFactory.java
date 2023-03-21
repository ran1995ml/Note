package com.ran.javase.designpattern.factory.factory;

import com.ran.javase.designpattern.factory.Bean;
import com.ran.javase.designpattern.factory.BeanA;
import com.ran.javase.designpattern.factory.BeanB;
import com.ran.javase.designpattern.factory.BeanC;

/**
 * SubFactory
 * 把实例化的过程推迟到子类
 * @author rwei
 * @since 2023/2/22 16:43
 */
public class SubFactory extends Factory {
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
