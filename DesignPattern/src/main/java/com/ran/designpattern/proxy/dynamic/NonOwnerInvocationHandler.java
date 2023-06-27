package com.ran.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * NonOwnerInvocationHandler
 * 客户修改其他人资料时使用
 * @author rwei
 * @since 2023/6/26 14:25
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    private PersonBean personBean;

    public NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(personBean, args);
            //只允许修改其他人的setHotOrNotRating方法
        } else if (method.getName().equals("setHotOrNotRating")) {
            return method.invoke(personBean, args);
        } else if (method.getName().startsWith("set")) {
            throw new IllegalAccessException("Permission denied");
        }
        //调用其他方法，返回null
        return null;
    }
}
