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
