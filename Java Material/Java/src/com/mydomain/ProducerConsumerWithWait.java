package com.mydomain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class ProducerConsumerWithWait extends Thread{

	public static List<String> dataList = new ArrayList<String>();
	
	public void run() {
		InputStreamReader r=new InputStreamReader(System.in);  
		BufferedReader br=new BufferedReader(r);  
		try{
			while(true){
				synchronized (dataList) {
					System.out.print("Enter text: ");
					String text = br.readLine();
					dataList.add(text);
					dataList.notify();
					dataList.wait();
				}
				System.out.println("Notified...");
			}
		}catch(Exception e){}
		
	}
	
	public static void main(String[] args) throws Exception{
		ProducerConsumerWithWait pc = new ProducerConsumerWithWait();
		pc.start();
		while(true){
			synchronized (dataList) {
				System.out.println("Waiting...");
				dataList.wait();
				System.out.println("Processing...");
				if(dataList.size()>0){
					String str = dataList.get(0);
					dataList.clear();
					System.out.println("Consumer got data: "+str);
				}
				dataList.notify();
			}
		}
	}
}
