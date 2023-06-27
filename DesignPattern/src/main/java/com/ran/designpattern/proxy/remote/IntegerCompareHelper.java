package com.ran.designpattern.proxy.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * IntegerCompareHelper
 * 服务辅助对象
 * @author rwei
 * @since 2023/6/26 10:53
 */
public class IntegerCompareHelper extends UnicastRemoteObject implements CompareHelper<Integer> {

    protected IntegerCompareHelper() throws RemoteException {
    }

    @Override
    public boolean compare(Integer object1, Integer object2) throws RemoteException {
        return object1 - object2 > 0;
    }

    @Override
    public Integer append(Integer object1, Integer object2) throws RemoteException {
        return Integer.valueOf(object1.toString() + object2.toString());
    }
}
