package com.mydomain;

public class ProfileApp {
	public static void main(String[] args) {
		System.out.println("Started computation");
		for(int i=0; i< 100000000; i++){
			Math.sin(i);
			System.out.println("Sin done");
			Math.cos(i);
			System.out.println("Cos done");
		}
		System.out.println("Done...");
	}
}
