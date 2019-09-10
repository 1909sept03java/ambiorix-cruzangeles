# 9/3/2019 Java and OOP

client side computer sends an http request to a server side computer
server side computer would give a response

client side:
html css js-typescript/angular

server side:
java sql

devOps is a way to automate deployment and testing
amazon web services- AWS

there are different frameworks that implement a lot of these HTTP requests

every monday is business professional- QC assessment

downloads:
we are going to be using Eclipse
Eclipse IDE for Java EE Developers | Eclipse Packages
Java SE Development Kit 8 - Downloads - Oracles

Welcome to Java!
Object Oriented Programming w/ Java!
Java has classes and objects
It contains many primitive data types
arrays - a space in memory, uses index's, can hold multiple things
stack - stack trace
heap - dynamically allocated memory space
strings - a special class in java
type conversion - float to int, string to int, etc
operators - + / * || $ and or xor nor

Java is
Portable
Syntax is based on C
Rich API
free!
Backed up by oracle
No pointers!

myProgram.java -> (compiler) -> myProgram.class -> (Java VM) -> the program runs!

API = Application Programming INterface

JDK contains the JRE, the JRE contains the library files and the JVM
-a bunch of already made libraries and cool things are already supported!

Write once and run anywhere!

Class - a blueprint that defines
	State (variables)
		car has wheels
	behavior (methods)
		car can drive
	state and behaviour are "class members:

Object - an instance of a class
	Objects are created from class blueprints
	2005 Honda Civic is a Car

Java Syntax

MyClass() className = new MyClass();

class MyClass {
	int variable;
	String word;

	void myMethod(){
		//method implementation
	}
}

filename then becomes myClass.java

there are privates, finals, public, protected are modifiers
that change if the class and variables can be accessed

class names always start with upper case
methods are done using camel case

methods play around with variables or do things (behavior)
parameter / argument

method scope, variable scope

## Abstraction

"Hiding of method implmentation and exposing functionality"
interfaces, abstract classes, abstract methods

## Polymorphism

"The ability for an object to have varying behavior based on how it is instantiated or how its methods are referenced"
method overloading, method overriding, covariant types

## Inheritance

"Ability for objects to inherit state behavior from other objects"
extents, implements

## Encapsulation

"Restriction of access to data"
Private instance variables and public getters and setters
