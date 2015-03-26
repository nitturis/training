package com.mydomain;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("localhost", 5000);
		OutputStream os = s.getOutputStream();
		System.out.println("Connected to server...");
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(new Vehicle(2000, "purple"));
		oos.close();
		System.out.println("Sent a vehicle to server.");
		
	}
}
