package com.mydomain;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	private static Runnable myRunnable = new Runnable() {
		
		public void run() {
			double result = 0;
			for(int i = 0; i< 10000; i++){
				result+=Math.sin(i);
			}
			System.out.println("Sin computation result: "+result);
		}
	}; 
	
	private static Callable<Double> myCallable = new Callable<Double>() {

		public Double call() throws Exception {
			double result = 0;
			for(int i = 0; i< 10000000; i++){
				result+=Math.sin(i);
			}
			System.out.println("Computation done");
			return result;
		}
	};
	
	public static void main(String[] args) throws Exception{
		ExecutorService exService = Executors.newFixedThreadPool(1);
		//exService.submit(myRunnable);
		Future<Double> futureValue = exService.submit(myCallable);
		System.out.println("Thread fired");
		Double result = futureValue.get();
		System.out.println("Sin computation result = "+result);
	}

}
