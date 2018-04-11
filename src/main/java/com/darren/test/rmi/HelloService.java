package com.darren.test.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote{

    void say(String words) throws RemoteException;
}
