# 10/11/2019

## Spring Boot (Version 2)

Spring Project (Not a module)

Designed so you can quickly spin up a web application that "just runs"
"Convention over configuration"
-> There are many default configurations are assumed by Spring Boot

Search for components in subdirectories of wherever class annotated with (@SpringBootApplication is located)

Autoconfigure based on classpath dependencies

package project as a .jar because it contains an embedded tomcat server
(cool)

there is a Maven plugin for running from the command line

preference for java-based config (@Configurationclasses) for bean definition

application.properties or application.yml
-> for sending information src/main/resources

Spring Boot Actuator
-> exposes endpoints for monitoring application

devtools -> include dependency so that wherever source changes app redeploys

start.spring.io
Spring Boot Initializer

@SpringBootApplication
contains @Configuration, @EnableAutoConfiguration, @ComponentScan

## Web Service

Standard means of interperation between software applications over the internet

REST (Representational State Transfer) ->
Architectural style of web service
Stateless -> Service does not track activity between requests ( no session )
Statefull -> Service does keep track of activity between requests ( sessions with tokens )
Request-Response Messaging Pattern
Client (consuming RESTFul web service) sends requests
Service (Exposing RESTFul web service) sends responses
HTTP/HTTPS Only
You are not restricted to a format for exchanging data (JSON, xml, text, html, etc)
The client and service should agree on what they send as requests and responses

Exposing RESTFul web services
Servlets
Spring MVC (or Spring REST is a special case)

Consuming RESTFul web services
From Java: RestTemplate
Browser Search Bar
Ajax and Fetch (JavaScript)
HttpClient (Angular)
HTML Forms

Handle Errors?
-> Simple message accompanying HTTP status codes
