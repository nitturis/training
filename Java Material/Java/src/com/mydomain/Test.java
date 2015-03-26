package com.mydomain;

public class Test {
	public static void main(String[] args) {
		System.out.println("AaAa".hashCode());
		System.out.println("BBBB".hashCode());
		System.out.println("BBAa".hashCode());
	}
	
	static class Vehicle{
		int engineSize;
		String color;
		
		public Vehicle(int engineSize, String color){
			this.engineSize=engineSize;
			this.color=color;
		}
		
		public Vehicle() {
			this(1000,"Red");
			System.out.println("Building vehicle");
		}

		protected void finalize() throws Throwable {
			System.out.println("Cleaning up...");
		}
	}
	class Car extends Vehicle{
		String brand;
		
	}
}
