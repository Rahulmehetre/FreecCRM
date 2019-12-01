package com.crm.qa.base;

public class MethodOverloading {

	public static void main(String[] args) {
		
		MethodOverloading obj = new MethodOverloading();
		
		obj.sum();
		obj.sum(10);
		obj.sum(10, 5);
				
	}
	
	// Main method can be overloaded
	
	public static void main (int p){
		
	}
	
	public static void main(int k, int q){
		
	}
	
	
	// you can not create method inside a method
	// duplicate methods - same method name with same parameters are not allowed
	// when method name is same with different arguments or parameters within the same class - Method overloading
	
	public void sum() // Zero Parameters
	{
		System.out.println("Sum Method - zero parameters");
		
		// public void test()
		
	}
	
	public void sum(double k) // same name different datatypes allowed
	{
		System.out.println("Sum Method - zero parameters");
	}
	

	public void sum(int i)
	{
		System.out.println("Sum Method - 1 input parameters");
		System.out.println(i);
	}
	

	public void sum(int j, int k)
	{
		System.out.println("Sum Method - 2 parameters");
		System.out.println(j+k);
	}
}
