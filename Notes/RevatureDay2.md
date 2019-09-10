# 9/4/2019

Review from yesterday-

Front end: what the client will interact with, what they click on, etc
Back end: databases, requests, responses, the behind the scenes

Java: free, backed by oracle, write once run everywhere, OOP, a lot of API's
JDK: Java Development Kit - Compiler, Debugger, contains the JRE
JRE: Java Runtime Environment - libraries we use, contains the JVM
JVM: Java Virtual Machine - garbage collector, stack, heap, executes ".class" files

Stack: contains method calls and local variables
Heap: objects and string pool

main() {
    method1();
    method2();
}
method1() {
    method3(); // error here
}

Stack trace:
    method3() // something happened here
    method1()
    main()

{ } denote a block of code
static { } executes once
non static { } executes for every instance

method scope: the block of code contained within a method
block scope: the block of code contained within { }

class Employee() {
    int id;
    String name;
    static String company;
    static int numWorkers;
}

## Constructors

private static int numWorkers = 0;
instance and static variables have default values
it is not required to to initialize things to 0
NULL: a reference that points to nothing
Garbage Collector: objects that are not being referenced get collected

local variables do not have default values

Employee e1 = new Employee();

if you don't explicitly make a constructor, there exists a default constructor

public Employee() { // no arguments
    Super(); // a method from the Object class that is already in Java
}

public Employee(int id, String name) {
    this.id = id;
    this.name = name;
}

"this." refers to the variables of the current instance
a default constructor only exists if there is no other constructor
if a constructor exists, then the default constructor no longer exists
it must be re-implemented

implicitly, the first line of a constructor is a call to Super();
the only time super() is never implicitly called is when you use the this()
method to call another constructor as the first line of the current constructor

there can only be one var arg in a method, it has to be the last parameter
randomFunc(int x, int y, int... nums) //this works, requires x and y
randomFunc(int... nums) //this works

## Interfaces

like a contract, can't make an instance of an interface
a class has to extend an interface
interfaces have names that end in -able
if a 100 classes implement an interface- and there is a change to the
interface, then you have to overwrite those methods for all the 100 classes
in java 8, if you don't want the 100 classes to have to be re-written b/c
of a change to an interface, then you must use the keyword default in the
methods of the interface file
variables in interfaces are public static final - because you can't instantiate
an interface
you must use the abstract keyword in an abstract class, abstract classes
doesn't do it by default because they expect the user to implement stuff

Animal pup = new Dog();

pup is of type Animal but it only takes the relevant methods of Dog()
and the overriden methods of Dog(). It does not take the new methods created
by the Dog() class implementation of Animal.

Beta 44
4 44
Baap 44
44 44

pup takes all the instance variables of Animal but all the common overriden methods of Dog.
If pup is set to cast a dog, as a Dog, then, it takes all of the instance variables of Dog
instead of Animal.

The implicit super() is made only for no arg constructors and default constructors.

Binary Digit = Bit
Byte = 8 Binary Digit's = 8 Bit's

## Wrappers

Integer, Boolean, Character - wrapper classes that contain a lot of information
It is not considered CASTING, it is AUTOBOXING.
Great way to use things like Integer.MAX_VALUE

Parsing lets you convert Strings from files or user input to integers

post incrementation occurs AFTER everything within a statement is done
pre incromentation occers BEFORE

left bit shift: <<
right bit shift: >>

## Object

equals()
hashcode()
finalize()
toString()

equals() tests for equality in the String class
== checks for memory locations when talking about objects

these work as bit wise operators too
bitewise or : | evaluates both sides
bitwise and : & evaluates both sides
exponents : ^

|| is a short circuit or, evaluates the left then the right
&& is a short circuit and, evaluates the left then right
