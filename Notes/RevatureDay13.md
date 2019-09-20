# 9/20/2019

## Client and Server Interaction

### HTTP Requests and HTTP Response

HTTP Requests-
URL
HTTP VERSION
HEADERS
REQUESTS METHOD
BODY

HTTP Response-
HTTP VERSION
HEADERS
BODY
STATUS CODE

HTTP Status Codes-
100-199 returns info related things
200-299 returns success
300-399 returns redirections to another URL
400-499 returns client error
500-599 returns server error

### GET and POST

GET (q=?)
Append Requests Params to URL (using QUERY Strings)
limited to length of url (few thousand characters)

POST
USES REP. BODY
Sending sensitive info (can't be bookmarked)
doesn't append info to url
a little less convinient to get sensitive info
can send any amount of content

WHAT WE WANT:
send multiple asynchronous requests
independently of each other

TOOLS:
AJAX - Asynchronous Javascrip and XML
set of interactions between the html dom
and xmlhttprequest js object which you
may obtain from the browser
server:
receive requests, construct and return a response
client:
event occurs, create/obtain XHR object, send request, process response and update page

XHR OBJECT:
supported by most modern browsers used to exchange data with a server
XHR methods:
open(method, url, async, username, password)
setRequestHeaders(name, value)
send(content)

XHR properties:
onreadystatechange -> assign to a function which executes when readystate property changes

XHR readystate:
indicates progress of request
0 not initialized
1 server conn established
2 request received
3 processing request
4 response is ready

FETCH

XML
Extensive Markup Language
Data Storage and Transfer format designed to be
both human readable and machine readable

wellformed xml - opening tags have closing tags, cases match
nesting is done correcting, basic structural rules were followed
valid xml - follows a specific DTD (document type definition)
or XSD (xml schema definition) (written in xml, can spcify datatypes)

