package com.mydomain;

import java.lang.reflect.Method;
import java.rmi.RemoteException;

public class ProxyImpl implements java.lang.reflect.InvocationHandler {

	private Object obj;

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass()
				.getClassLoader(), obj.getClass().getInterfaces(),
				new ProxyImpl(obj));
	}

	private ProxyImpl(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		Object result;
		try {
			//do something before
			System.out.println("Actions before invoke of: "+m.getName());
			System.out.println(this);
			result = m.invoke(obj, args);
			System.out.println("Actions after method invoke...");
			//do something after
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: "
					+ e.getMessage());
		}
		return result;
	}

	public static void main(String[] args) throws RemoteException {
		RemoteCalculatorImpl target = new RemoteCalculatorImpl();
		RemoteCalculator proxy = (RemoteCalculator)ProxyImpl.newInstance(target);
		proxy.calculateSin(20);
	}
}
