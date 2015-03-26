package com.mydomain;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public class Vehicle implements Comparable<Vehicle>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6384964601441739446L;
	int engineSize;
	String color;
	transient Connection con;
	
	@Override
	public int compareTo(Vehicle o) {
		if(this.engineSize>o.engineSize)
			return 1;
		else if(this.engineSize<o.engineSize)
			return -1;
		else
			return 0;
	}

	public Vehicle(int engineSize, String color) {
		super();
		this.engineSize = engineSize;
		this.color = color;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((color == null) ? 0 : color.hashCode());
//		result = prime * result + engineSize;
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (engineSize != other.engineSize)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Vehicle [engineSize=" + engineSize + ", color=" + color + "]";
	}

	public void startEngine() {

	}

	public static void startEngines(Vehicle v) {
		System.out.println("Starting engine");
		v.startEngine();
	}

	public static void main(String[] args) {
		Vehicle v = new Vehicle(2,"red");
		v.fn4();
	}

	public void mysql() throws SQLException{
		throw new SQLException("Something went wrong");
	}

	public void fn2() throws IOException {
		try {
			mysql();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public void fn3() throws Exception {
		try {
			fn2();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void fn4() {
		try {
			fn3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


