package com.mydomain;

public class InnerClasses {

	private String x;
	public static class InstanceClass{
		String innerX;
	}
	
	public static void main(String[] args) {
		
		NonPublicClass pc = new NonPublicClass();
		new Thread(){
			public void run(){
				int k=0;
				for(int j=0; j< 1000; j++){
					k = j;
					System.out.println("######### Value of j = "+j);
				}
			}
		}.start();

		
		Thread x = new Thread(new Runnable(){
			public void run() {
				//Whatever thread code here
			}
		});
	}
}

class NonPublicClass{
	String abc;
}
