package com.mydomain;

public class Car implements Steerable{
	@Override
	public void turnLeft() {
		System.out.println("Car Turning Left");
	}
	@Override
	public void turnRight() {
		System.out.println("Car Turning Right");
	}
	
	public void testInCar(){
		System.out.println("test in car");
	}
	
	public static void main(String[] args) {
		Steerable s = new Car();
		Steerable s2 = new Steerable(){
			public void turnLeft() {
				System.out.println("Anonymous class turning Left");
			};
			public void turnRight() {
				System.out.println("Anonymous class turning Right");
				test();
			};
			private void test(){
				System.out.println("test method");
			}
		} ;
		
		s.turnRight();
		((Car)s).testInCar();
		s2.turnRight();
		//s2.test();
		
		System.out.println(s.getClass().getName());
		System.out.println(s2.getClass().getName());
	}
}
