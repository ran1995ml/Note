package com.ran.designpattern.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * PersonProxy
 * 代理类
 * @author rwei
 * @since 2023/6/26 14:30
 */
public class PersonProxy {

    //代理和主题有相同的接口，返回代理类
    public PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
    }

    public PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(), new NonOwnerInvocationHandler(personBean));
    }
}
