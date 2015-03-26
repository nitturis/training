package com.mydomain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer extends Thread{

	public static List<String> dataList = new ArrayList<String>();
	
	public void run() {
		InputStreamReader r=new InputStreamReader(System.in);  
		BufferedReader br=new BufferedReader(r);  
		try{
			while(true){
				System.out.print("Enter text: ");
				String text = br.readLine();
				dataList.add(text);
				if(text.equals("exit"))
					break;
			}
		}catch(Exception e){}
	}
	
	public static void main(String[] args) throws Exception{
		ProducerConsumer pc = new ProducerConsumer();
		pc.start();
		while(true){
			Thread.sleep(100);
			if(dataList.size()>0){
				String str = dataList.get(0);
				dataList.clear();
				System.out.println("Consumer got data: "+str);
				if(str.equals("exit"))
					break;
			}
		}
	}
}
