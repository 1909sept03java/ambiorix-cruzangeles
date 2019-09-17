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