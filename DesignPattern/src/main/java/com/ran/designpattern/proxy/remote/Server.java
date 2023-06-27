package com.ran.designpattern.proxy.remote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Server
 * 创建RMI注册表，启动RMI服务，并将远程对象注册到RMI注册表中
 * @author rwei
 * @since 2023/6/26 10:57
 */
public class Server {
    private static final String HOST = "localhost";

    private static final int PORT = 9090;

    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        IntegerCompareHelper integerCompareHelper = new IntegerCompareHelper();
        LocateRegistry.createRegistry(PORT);
        Naming.bind("rmi://" + HOST + ":" + PORT + "/IntegerCompareHelper", integerCompareHelper);
        System.out.println("Bind object success.");
    }
}
