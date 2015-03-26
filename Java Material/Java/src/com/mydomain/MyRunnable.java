package com.mydomain;

public class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<1000; i++){
			System.out.println("Value of i "+i);
		}
	}
	
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		for(int i=0; i<1000; i++){
			System.out.println("Value of i ********** "+i);
		}
		System.out.println("Started thread");
	}
	
}
