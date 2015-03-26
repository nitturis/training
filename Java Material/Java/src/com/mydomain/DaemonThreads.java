package com.mydomain;

public class DaemonThreads extends Thread{

	@Override
	public void run() {
		for(int i=0; i<1000; i++){
			System.out.println("Value of i = "+i);
		}
	}
	public static void main(String[] args) {
		DaemonThreads t = new DaemonThreads();
		t.setDaemon(true);
		t.start();
		System.out.println("Started thread");
	}
}
