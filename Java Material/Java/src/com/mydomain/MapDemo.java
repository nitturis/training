package com.mydomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<Car,List<String>> carsAndOwners = new HashMap<Car,List<String>>();
		Car c1 = new Car();
		c1.engineSize=1000;
		c1.color="blue";
		
		Car c2 = new Car();
		c2.engineSize=2000;
		c2.color="red";
		
		Car c3 = new Car();
		c3.engineSize=1000;
		c3.color="blue";
		
		List<String> owners = carsAndOwners.get(c1);
		if(owners==null){
			System.out.println("No owner for c1.. creating one");
			owners = new ArrayList<String>();
			carsAndOwners.put(c1, owners);
		}
		owners.add("Mahendra");
		
		owners = carsAndOwners.get(c3);
		if(owners==null){
			owners = new ArrayList<String>();
			carsAndOwners.put(c1, owners);
		}else{
			System.out.println("Existing owner for this car.. so not creating a list");
		}
		owners.add("Mary");
		
		System.out.println(carsAndOwners.get(c1));
		
//		
//		//Map<Car,String> carsAndOwners = new HashMap<Car,String>();
//		
//		
//		carsAndOwners.put(c1, "Mahendra");
//		carsAndOwners.put(c2, "Krishna");
//		//String oldOwner = carsAndOwners.put(c3, "Mary");
//		
//		//System.out.println("New owner: "+carsAndOwners.get(c3));
//		//System.out.println("Old owner: "+oldOwner);
//		
//		Set<Car> keys =  carsAndOwners.keySet();
//		for (Car car : keys) {
//			System.out.println(carsAndOwners.get(car));
//		}
		
//		MapDemo m = new MapDemo();
//		m.x = 10;
//		
//		Car c =m.new Car();
		
		MapDemo.x = 10;
		Car c = new MapDemo.Car();
	}
	
	static int x;
	
	static class Car{
		int engineSize;
		String color;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((color == null) ? 0 : color.hashCode());
			result = prime * result + engineSize;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Car other = (Car) obj;
			if (color == null) {
				if (other.color != null)
					return false;
			} else if (!color.equals(other.color))
				return false;
			if (engineSize != other.engineSize)
				return false;
			return true;
		}
		
	}
}

