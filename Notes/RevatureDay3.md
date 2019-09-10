# 9/5/2019

Strings are immutable. They can't change
String str = "hello"
str = "hello world"
this does not add "world" to "hello"
this simply points str to a new location
in the string pool that now contains "hello world"

## loops

break is a keyword used to break out of the current loop
continue would skip the rest of the code under it go to the next iteration
for ( ; ; ) //is the default way to write a for loop
for ( index : array ) // for each loop
while ( conditionIsTrue ) // while loop
do {} while(conditionIsTrue) // do-while runs at least once

## switch statements

switch statements are almost like if statements
it checks every case and does not use a range like a condition
in an if statement

switch(var) {
    case 0:
        //code
        break;
    case 1:
        //code
        break;
    case 2:
        //code
        break;
    case 3:
        //code
        break;
    default:
        //code
        //does not need a break
}

## Scanner

reading in from user input

Scanner scanner = new Scanner(System.in);
reads in from the command line

## Access modifiers/levels

public: accessible anywhere, from any other class

protected: accessible only from classes in the same package
or any subclasses even if it is out of the package

no modifier: aka default aka package only, only acessible from
clases within the package

private: only accessible within the class it is declared in
(only have private classes if they are nested)

when you override a method you can make it more public
not more private, private methods can't be overriden because
an extended class can't see the private methods of it's super
class.

## Final keyword

variable: can not reassign once initialized "constants"
method: can not be overriden but it can be overloaded
class: can not be extended

finally: execption handling
finalize: method that the garbage collector calls before it collects objects

## Strings

String words = new String("HELLO!");
String words = "HELLO!";

are the ways to create strings
strings are immutable and can't be changed

## Arrays

sorting, as list, etc very important methods to keep in mind

## Exception Handling

whenever you don't handle exceptions, your code will stop running
when it does something it can't really handle during run time
exception handling lets you continue running your code even if there
is some sort of error in it during runtime

throwable has two children
error and exception

exception has one child, runtime exception

everything that is throwable can be caught,
so error can be caught and exception can be caught

exception can be "fixed"
error can't be "fixed"

an exception is something the coder can see in order to prepare
his/her code for tricky situations

runtimeExceptions are rather trickier so they can go unchecked
and occur naturally

## try and catch blocks

try {
    // risky code here that would stop
}
catch(Exception e) {
    // catching it and reporting it
    // the most general form of catching an exception
    // place other exceptions above this one
}
// rest of the code runnnns

## error vs exception

they both extend throwable so they can be thrown at runtime

errors can't be programmatically recovered from
errors should not be caught because of this

## Input and Output to a file

CHECKED EXCEPTIONS MUST BE HANDLED
mainly happens when dealing with IO libraries of java
in order to fix this or to handle it, the problem can be passed
on by "throws" it to make it another methods problem
in this case, it's best to use a try and catch block in order
to handle the exception before it occurs (anticipated)

throw indicates that you have made your own exception and you
would like the JVM to throw it when someone uses your method
throw is inside of a method where as throws is after a method
signature

catching it- ducking it (propogating it)-

## throw vs throws

throw new Exception
methodA() throws exception

## Custom Exceptions

extends the Exception class and write your own exception
uses of your code can use your exception as well

try {

}
catch() {

}finally{

}

try must have a catch or finally block
finally is used to close databases files and network connections

finally blocks of code will always execute unless some fatal error occurs

you will hardly ever see finally used because of something called auto
closable

## Data Structures

collections-
list, set, and queues

maps, iterable, comparable

team 2 is sets!!! lets go!!!
interface, definitions, describe high level each of the classes that implement these sets

ArrayList<E>;
ArrayList<Integer> myNums = new ArrayList<Integer>();
