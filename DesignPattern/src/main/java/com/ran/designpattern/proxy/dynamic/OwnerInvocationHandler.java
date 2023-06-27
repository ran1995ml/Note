package com.ran.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * OwnerInvocationHandler
 * 客户修改自己资料时使用
 * @author rwei
 * @since 2023/6/26 14:14
 */
public class OwnerInvocationHandler implements InvocationHandler {
    private PersonBean personBean;

    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        if (method.getName().startsWith("get")) {
            return method.invoke(personBean, args);
            //个人不允许对自己调用setHotOrNotRating方法
        } else if (method.getName().equals("setHotOrNotRating")) {
            throw new IllegalAccessException("Permission denied");
        } else if (method.getName().startsWith("set")) {
            return method.invoke(personBean, args);
        }
        //调用其他方法，返回null
        return null;
    }
}
