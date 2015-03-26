package com.mydomain;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Streams {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("/Users/maruthir/Desktop/abc.txt");
		int x = 500;
		fos.write(x);
		fos.write(x>>8);
		fos.write("500".getBytes());
		fos.close();
		FileInputStream fis = new FileInputStream("/Users/maruthir/Desktop/abc.txt");
		int val1 = fis.read();
		int val2 = fis.read();
		int val3 = val1 | (val2<<8);
		fis.close();
		System.out.println(val3);
		
		fos = new FileOutputStream("/Users/maruthir/Desktop/abc.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(500);
		dos.close();
		
		fis = new FileInputStream("/Users/maruthir/Desktop/abc.txt");
		DataInputStream dis = new DataInputStream(fis);
		int val4 = dis.readInt();
		dis.close();
		System.out.println(val4);
		
		fos = new FileOutputStream("/Users/maruthir/Desktop/abc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Vehicle(1000,"red"));
		oos.close();
		
		fis = new FileInputStream("/Users/maruthir/Desktop/abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Vehicle v2 = (Vehicle)ois.readObject();
		ois.close();
		System.out.println(v2.color);
		
		long start = System.currentTimeMillis();
		fis = new FileInputStream("/Users/maruthir/Desktop/abc.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		while(true){
			int k = bis.read();
			if(k==-1)
				break;
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start));
		
		
	}
}
