package com.mydomain;

public class ThreadRacing extends Thread{

	public static int k=0;
	
	public void run() {
		for(int i=0; i< 1000; i++){
			synchronized (this) {
				k = i;
				System.out.println("Value of i = "+k);
				if(k!=i){
					System.out.println("This cant print!!!!!!!!!!!!");
				}
			}
		}
	}
	
	public synchronized void func(){
		for(int j=0; j< 1000; j++){
				k = j;
				System.out.println("######### Value of j = "+j);
				if(k!=j){
					System.out.println("This cant print!!!!!!!!!!!!");
				}
		}
	}
	public static void main(String[] args) {
		ThreadRacing t = new ThreadRacing();
		t.start();
		//ThreadRacing t2 = new ThreadRacing();
		t.func();
	}
}
