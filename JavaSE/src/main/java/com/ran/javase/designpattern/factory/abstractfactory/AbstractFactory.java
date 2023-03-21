package com.ran.javase.designpattern.factory.abstractfactory;

import com.ran.javase.designpattern.factory.Bean;
import com.ran.javase.designpattern.factory.Domain;

/**
 * AbstractFactory
 * 抽象工厂模式
 * 对类进行分组，采用工厂中的不同方法创建不同的类，减少工厂子类
 * @author rwei
 * @since 2023/2/22 17:07
 */
public interface AbstractFactory {
    public Bean createBean(String type);

    public Domain createDomain();
}
