package com.revature;

public class GarbageCollection {

	/*
	 * Included memory management
	 * A daemon thread (a thread that never dies) in the JVM that 
	 * deallocates memory to unreferenced entities
	 */
	
	public static void main(String[] args) {
		MyGarbage g1 = new MyGarbage("1");
		MyGarbage g2 = new MyGarbage("2");
		MyGarbage g3 = new MyGarbage("3");
		MyGarbage g4 = new MyGarbage("4");
		MyGarbage g5 = new MyGarbage("5");
		MyGarbage g6 = new MyGarbage("6");
		g6 = g2;
		g1 = null;
		g3 = g5;
		g4 = g1;
		System.gc();
		for(int i = 0; i < 1000; i++) System.out.print("blah ");
	}
	
}

class MyGarbage {
	
	String name;
	
	public MyGarbage(String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(name + " is being garbage collected!");
	}
	
}
