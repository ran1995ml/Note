package com.ran.designpattern.proxy.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Client
 * 调用远程对象上的远程方法
 * @author rwei
 * @since 2023/6/26 11:01
 */
public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        CompareHelper compareHelper = (CompareHelper) Naming.lookup("rmi://localhost:9090/IntegerCompareHelper");
        System.out.println(compareHelper.append(12, 14));
    }
}
