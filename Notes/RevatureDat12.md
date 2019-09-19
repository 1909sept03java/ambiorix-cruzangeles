# 9/19/2019

## Events

Categories:
Mouse, keyboard, loading, drag, animations...

Event listeners:
js objects which are applied to elements and have some
predefined behaviour (a callback function) to respond to a specific
event type occureing in that part of the dom

how to apply event listener

1. obtrusively (inline)
<div onclick = "someFunction"> </div>

2. short form, unobtrusively (in .js file)
[element].onClick = function() { } 
                    ^callback function

3. long form, unobtrusively
[element].addEventListener(event type, callback, useCapture);

event propagation

An events handling works on nested elements
"target" > elements where evet occurred

when event occurs,
js will traverse root -> target,
then target -> root to look for applicable listeners

bubbling -> listener callbaks will fire on target -> root traversal
default

capturing -> listener callbacks will fire on root -> target traversal

to stop propagation:
pass event object to event handler
use
event.stopPropogation()

not the same as cancelling an event

event object?
how to cancel an event?
the event must be cancelable first in order to cancel it 

JSON = Javascript object notation

Data format inspired by js objects

- name value pairs
- no 'undefined', functions, or numbers which are not base 10 as values
- names in quotes

JSON.parse(String)
- converts a string of Jason formatted data into a js object

JSON.strinify ( object)
-vice versa