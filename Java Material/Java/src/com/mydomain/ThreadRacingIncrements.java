package com.mydomain;


public class ThreadRacingIncrements extends Thread{

	public static int k=0;
	
	public void run() {
		for(int i=0; i< 10000; i++){
			k++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		ThreadRacingIncrements t = new ThreadRacingIncrements();
		t.start();
		for(int j=0; j< 10000; j++){
			k++;
		}
		t.join();
		System.out.println("Final K = "+k);
	}
}
