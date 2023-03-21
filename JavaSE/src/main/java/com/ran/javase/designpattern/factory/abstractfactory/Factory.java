package com.ran.javase.designpattern.factory.abstractfactory;

import com.ran.javase.designpattern.factory.*;

/**
 * Factory
 *
 * @author rwei
 * @since 2023/2/22 17:38
 */
public class Factory implements AbstractFactory {
    @Override
    public Bean createBean(String type) {
        if (type == "A") {
            return new BeanA();
        } else if (type == "B") {
            return new BeanB();
        } else {
            return new BeanC();
        }
    }

    @Override
    public Domain createDomain() {
        return new Domain();
    }
}
