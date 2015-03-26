package com.mydomain;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
	public static void main(String[] args) throws RemoteException {
		RemoteCalculator stub =
                (RemoteCalculator) UnicastRemoteObject.exportObject(new RemoteCalculatorImpl(), 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("myapp/remotecalc", stub);
            System.out.println("Remore calculator bound");
	}
}
