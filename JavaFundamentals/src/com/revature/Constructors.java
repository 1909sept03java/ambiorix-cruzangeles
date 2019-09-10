package com.revature;

public class Constructors {
	
	//instance and static variables typically go first
	private String aboutMe;
	
	//no arg constructor
	Constructors() {}
	
	//arg constructor
	public Constructors(String aboutMe) {
		super();
		this.aboutMe = aboutMe;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public static void main(String[] args) {
		C c = new C();
	}

}

class A {
	A() {
		//super()
		System.out.println("IN CLASS A CONSTRUCTOR");
	}
}

class B extends A {
	B() {
		//super()
		System.out.println("IN CLASS B CONSTRUCTOR");
	}
}

class C extends B {
	C() {
		//super()
		System.out.println("IN CLASS C CONSTRCUTOR");
	}
}