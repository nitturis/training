package com.mydomain;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCalculator extends Remote {
	BigDecimal calculateSin(Integer val) throws RemoteException;
	User getUser(Integer id) throws RemoteException;
}
