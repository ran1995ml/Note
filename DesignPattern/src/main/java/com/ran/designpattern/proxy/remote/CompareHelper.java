package com.ran.designpattern.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * CompareHelper
 * 远程接口，用于比较对象
 * @author rwei
 * @since 2023/6/26 10:44
 */
public interface CompareHelper<T> extends Remote {
    public boolean compare(T object1, T object2) throws RemoteException;

    public T append(T object1, T object2) throws RemoteException;
}
