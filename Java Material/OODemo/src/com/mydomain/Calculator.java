package com.mydomain;

public class Calculator {
	public float compute(int operand1, int operand2, String operation){
		Operatable operatable = OperatableFactory.getOperatable(operation);
		return operatable.compute(operand1, operand2);
	}
	
	public static void main(String[] args) {
		Calculator calc = new ScientificCalculator();
		int operand1 = 1;
		int operand2 = 2;
		float result = calc.compute(1, 2, "Add");
		System.out.println(operand1+" "+calc.getSign("Add")+" "+operand2+" = "+result);
	}
	
	private String getSign(String operation){
		if(operation.equals("add"))
			return "+";
		return "";
	}
}

class ScientificCalculator extends Calculator{
	public float compute(int operand1, int operand2, String operation) {
		if(operation.equals("sin")){
			return (float)Math.sin(operand1);
		}else if(operation.equals("cos")){
			return (float)Math.cos(operand1);
		}else
			return super.compute(operand1, operand2, operation);
	}
}

interface Operatable{
	int compute(int operand1, int operand2);
}

class AddOperation implements Operatable{
	public int compute(int operand1, int operand2) {
		return operand1+operand2;
	}
}

class SubOperation implements Operatable{
	public int compute(int operand1, int operand2) {
		return operand1-operand2;
	}
}

class OperatableFactory{
	static Operatable getOperatable(String operation){
		String className = operation+"Operation";
		try {
			Class operationClass = Class.forName("com.mydomain."+className);
			return (Operatable)operationClass.newInstance();
		} catch (Exception e) {
			// something went wrong in creating object..
			e.printStackTrace();
		}
		return null;
	}
}