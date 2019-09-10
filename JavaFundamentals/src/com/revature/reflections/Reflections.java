package com.revature.reflections;

//A simple Java program to demonstrate the use of reflection 
import java.lang.reflect.Method; 
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;

public class Reflections {

	private String s;
	
	public Reflections() {
		s = "default constructor";
	}
	
	public Reflections(String s) {
		this.setS(s);
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Reflections ref = new Reflections("Hello");
		
		// Creating class object from the object using getclass method 
        Class<? extends Reflections> cls = ref.getClass(); 
        System.out.println("The name of the class is " + cls.getName());
        
        // Getting the constructor of the class through the object of the class 
        Constructor<? extends Reflections> con = cls.getConstructor(); 
        System.out.println("The name of constructor is " + con.getName());
        
        // Getting methods of the class through the object of the class by using getMethods 
        Method[] methods = cls.getMethods(); 
  
        // Printing method names 
        for (Method method:methods) System.out.println("Methods: " + method.getName());
        
        // Creates an object of desired method by providing the method name and parameter
        // class as arguments to the getDeclaredMethod 
        Method setS = cls.getDeclaredMethod("setS", String.class);
        
        // invokes the method at runtime 
        setS.invoke(ref, "Hello world");
        
        System.out.println(ref.getS());
        
	}

}

