package com.mydomain;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(5000);
		while(true){
			System.out.println(Thread.currentThread().getName()+ ": Waiting for connection...");
			Socket s = ss.accept();
			ConnectionHandler c = new ConnectionHandler(s);
			c.start();
		}
	}
}
class ConnectionHandler extends Thread{
	Socket s;
	public ConnectionHandler(Socket s) {
		this.s = s;
	}
	public void run() {
		try{
			System.out.println(Thread.currentThread().getName()+ ": Accepted a connection...");
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Vehicle v = (Vehicle)ois.readObject();
			ois.close();
			System.out.println(Thread.currentThread().getName()+ ": Got vehicle with color: "+v.color);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}