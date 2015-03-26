package com.mydomain;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		String name = "myapp/remotecalc";
		Registry registry = LocateRegistry.getRegistry("localhost",1099);
		RemoteCalculator calc = (RemoteCalculator) registry.lookup(name);
		System.out.println(calc);
		User u = calc.getUser(1);
		System.out.println(u.getName());
	}
}
