# 9/18/2019

## responsive design

is modifying layout of pages for different devices
how things look like on a full are different than
how they look on a giant tv
-- plain css w/ media queries
-- library like bootstrap
-- flexible grid lines

## bootstrap 4

made by twitter
libraries on css + javascript which can be included
in your front_end for stlying and responsiveness

-- can download and link it locally
-- can use CDN: Content Delivery Network

## bootstrap grid lines

12 columns
the grid lines allow for a relocation of the elements
within the screen depending on the viewport size

## group assignment

rebuild yesterday's size with bootstrap
responsive navbar
1 other custom component
different number of columns depending on screen size

## Javascript

NOTHING LIKE JAVA!
object oriented
c language syntax
loosely typed/ dynamic typing
JAVA has strongly typed syntax or "static" typing
datatypes in javascript are determine at runtime, not when compiled

java-
int x = 5;
y = "hello"; // DOES NOT WORK

javascript
let x - 5;
y = "hello"; // DOES WORK

follows ECMAScript
ES3 -> 1999
ES5 -> 2009 , json stuff
ES6 -> 2015 , blocked scope variables and classes, let and const, template literals, arrow notation

JS is interpreted not compiled
can be run line by line

in a JS runtime, environment with engine + attendant libraries

JIT - Just In Time compiling

datatypes
number
-64-bit floating point
- not accurate 0.3-0.2!=0.1

strings
- 0 or more 16bit characters
- "" or ''
- immutable
- string.length

boolean
- true, false
- truthly, falsely , non boolean values can be interpreted as true or false

truthly
all non-falsy values

falsy
false
null
NaN
undefined
""
0

functions
JS functions are objects that can be passed, returned, stored like any other value
JS is the 1st mainstream lambda based language
function inherits from object
functions can have properties

syntax:

let myFunction = function (arg0, arg1, ...) {

}

objects
collections name/value pairs
name -> any string
value -> any value besides undefined

object creation

1) object literal
let person = { "name"="fred", "occupation"="astronaut"}

2) constructor
function Person(name, occupation) {
    this.name = name;
    this.occupation = occupation;
}

3) maker functions
function makePerson(name, occupation) {
    return { "name"=name, "occupation"=occupation}
}

accesing object properties
fred.name
fred["name"]
