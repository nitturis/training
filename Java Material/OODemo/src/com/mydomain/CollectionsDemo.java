package com.mydomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {
	public static void main(String[] args) {
		String m = "Hello";
		@SuppressWarnings("rawtypes")
		List normalList = new LinkedList();
		normalList.add(10);
		normalList.add(m);
		for (Object object : normalList) {
			if(object instanceof Integer){
				Integer i = (Integer)object;
				System.out.println(i);	
			}else{
				String k = (String)object;
				System.out.println(k);
			}
		}

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(15);
		for (Integer i : intList) {
			System.out.println(i);
		}
		
//		for(int i=0; i< intList.size(); i++){
//			intList.remove(i);
//			System.out.println(intList.get(i));
//		}

		intList.clear();
		for(int i=0;i<100;i++){
			intList.add(i);
		}
		
		List<Integer> temp = new ArrayList<Integer>();
		for(Integer intVal : intList){
			if(intVal%5!=0){
				temp.add(intVal);
			}
		}
		intList = temp;
		System.out.println("---------------------------------------------------------");
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);s.add(2);s.add(3);s.add(3);s.add(4);
		for (Integer integer : s) {
			System.out.println(integer);
		}
		
		Set<Vehicle> s2 = new HashSet<Vehicle>();
		Vehicle v1 = new Vehicle(1000,"red");
		Vehicle v2 = new Vehicle(1000,"red");
		s2.add(v1);s2.add(v2);
		System.out.println("Vehicle set size: "+s2.size());
		
		System.out.println("---------------------------------------------------------");
		List<Vehicle> s3= new ArrayList<Vehicle>();
		Vehicle v3 = new Vehicle(2000,"red");
		Vehicle v4 = new Vehicle(2000,"red");
		Vehicle v5 = new Vehicle(2000,"red");
		s3.add(v3);s3.add(v4);s3.add(v5);
		
		Collections.sort(s3,new VehicleComparator());
		for (Vehicle vehicle : s3) {
			System.out.println(vehicle);
		}
		
		System.out.println("---------------------------------------------------------");
		
		Map<Vehicle,String> m1 = new HashMap<Vehicle, String>();
		m1.put(v1, "Mahesh");
		m1.put(v2, "Abhilash");
		m1.put(v3, "Jack");
		m1.put(v4, "Suma");
		
		System.out.println("Map value for 2: "+m1.get(v5));
		
		
	}
	
	static class VehicleComparator implements Comparator<Vehicle>{
		@Override
		public int compare(Vehicle o1, Vehicle o2) {
			return o1.color.compareTo(o2.color);
		}
	}
}
