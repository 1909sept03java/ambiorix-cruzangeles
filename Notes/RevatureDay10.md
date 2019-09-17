# 9/17/2019

## Client to Server Side interaction

client will ask for a http request from a server

the server will return an http response

the contents of the response hold a response body:
Resource or whatever,

can be an http file
can be a data formatted xml, json, plain text

the client side is known as the
"user agent"
-doesn't have to be a browser
any piece of web-aware software which can make a request and do something with the response

HTTP: Hyper Text Transfer Protocol

HTML: Hypertext Markup Language
used to give structure to webpages
organized by tags which are interpreted by a browser

it sets up the tags in a tree like structure that can be traversed using javascript
never want to use absolute paths, relative paths

<img src = "cats.jpg" >

relative pathing
best practice for local resources
cats.jpg would have to be on the same level as html file
images/cats.jpg, images folder is on same level as html file
../cats.jpg, it's one level above the html file

tag
a Hyperlinks
img Images

<head>
in here goes the title
some references to css files, etc
</head>

<body>
encases the extent of the whole webpage
there are all kinds of tags
paragraphs,
headings,
unordered lists,
ordered lists,

</body>

## CSS

CSS: Cascading Stylesheets
used to add styling to an html document
can standardize your styling accross multiple pages

inline <h1 style="background-color:blue"> this is blue </h1>

style attribute is the CSS
internal style
<style> 
h1 {
    background=color : blue;
}
</style>

external stylesheet
<head>

<link rel="stylesheet" href="styles.css">

styling rules cascade

into a virtual stylesheet
composed of all roles applied
intline, interally, externally

inline has highest precedence
internal and external have the same precedense
depends on order of links and stylesheet elements
browser default

CSS Rule Set

h1 {
    background-color : blue;
    margin : 10px;
}

3 types:
element - tag name
class - .classname applies the rule to all
id - #id  applies to elements w/ attribute class="class-name"
    - apply to element w/ attribute id="id"
    ideally, unique identifier for an element

h1, h2, h3 { ... }
all h1, h2, h3 elements

p.center { ... }
all p tags with class ="center"

div p { ... }
space - descendant selector all p inside a div
div > p :::: child selector
div + p :::: adjacent sibling selector
div ~ p :::: general sibling selector

CSS BOX MODEL
element -> padding -> border -> margin

build a webpage
text, pictures, etc
stylesheet w/ min 6 rules
flex-box is a plus
12 tags to be used
list
table
pick a theme

action is form handler
method is the http method

<form method= "get" action="url">
    <input type="text" name="inputToOutputOne">
    <input type="submit" value="submit this form"> -- button
</form>

HTTP REQUESTS COMPONENTS
URL
HEADERS
HTTP REQUESTS
METHOD
BODY

GET VS POST
