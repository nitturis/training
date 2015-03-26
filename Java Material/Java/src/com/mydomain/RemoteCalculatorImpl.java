package com.mydomain;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public class RemoteCalculatorImpl implements RemoteCalculator{

	@Override
	public BigDecimal calculateSin(Integer val) throws RemoteException {
		System.out.println("Calculating the sin...");
		double retVal = Math.sin(val);
		BigDecimal bd = new BigDecimal(retVal);
		return bd;
	}

	@Override
	public User getUser(Integer id) throws RemoteException {
		System.out.println("Getting the user...");
		User u = new User();
		u.id=1;
		u.name = "Manav";
		u.email="manav@gmail.com";
		return u;
	}

}
