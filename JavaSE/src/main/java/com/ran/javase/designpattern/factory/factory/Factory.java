package com.ran.javase.designpattern.factory.factory;

import com.ran.javase.designpattern.factory.Bean;

/**
 * UseFactory
 *
 * @author rwei
 * @since 2023/2/22 16:49
 */
public abstract class Factory {
    public abstract Bean createBean(String type);
}
