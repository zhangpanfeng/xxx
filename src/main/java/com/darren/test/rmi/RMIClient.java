package com.darren.test.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        String url = "rmi://localhost:1098/com.darren.test.rmi.HelloServiceImpl";
        HelloService service = (HelloService) Naming.lookup(url);
        service.say("hello world");
    }
    
}
