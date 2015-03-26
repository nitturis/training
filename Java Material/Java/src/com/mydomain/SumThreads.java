package com.mydomain;

public class SumThreads {

	static class Summer implements Runnable{
		int start;
		int end;
		@Override
		public void run() {
			for(int i=start; i< end; i++){
				Math.sin(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Summer s1 = new Summer();
		s1.start=0;
		s1.end = 10000000;
		Summer s2 = new Summer();
		s2.start=5000000;
		s2.end = 10000000;
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long end = System.currentTimeMillis();
		System.out.println("Duration: "+(end-start));
		
	}
}
