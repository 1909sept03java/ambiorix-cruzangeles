# 9/24/2019

## J2EE Architecture

DB <=> DAOS <=> Services <=> Servlets <=> Client Side

DB: Database stuff and tables are here, maybe stored procedures
DAOS: Data Access Objects, list of all rows in a table, etc
-also known as the persistence layer
Services: Business logic layer/service layer, with methods that call the stored procedures and deal with DAOs
Servlets: Presentation layer, controlling what is delivered to the client
Client Side: html page, pretty clicky stuff, forms, etc

If the app is "Web-Aware" (connected to the internet) it can send and receive http requests.
Able to communicate with other applications on the web.

## Servlet

nothing more and nothing less than a java class that can handle an incoming http request
and return a response, contains request handler methods which take a httpservletrequest and
httpservletreponse objects as args and are organized by:
a) path
b) http verb (get, post, put, delete)

Object         Servlet (Interface)
  |             /
GenericServlet (Abstract Class, Implements Servlet)
  |
HttpServlet (Abstract Class)
  /  |   \
The servlets go here!

## Request Handler Methods

doGet, doPost, doPut, doDelete, doTrace, doOptions, doHead

@Override // ensures that it gets a bit of extra check time to make sure that it does properly override a parent method
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

deployment descriptor
xml file
register your servlets with a web container
define url patterns for each
configuration file for your web app
web.xml

@WebServlet ()
can also be used to register and map servlets,
annotation-based application
instead

File -> New -> Other -> Server -> Apache -> Tomcat 9 -> local host and Tomcat v9.0 Server at localhost -> find your tomcat directory

go into server.xml -> source -> connector port to 8082

window -> show view -> server -> right click -> start

create a maven project -> WAR packaging -> right click on project -> java ee tools -> generate deployment stub

update pom.xml for java 1.8 and add the javax.servlet dependency

a marker interface has no methods and doesn't define any methods, if something extends the serializable class, then that means that code and or objects can be serialized to go through a network

edit web.xml
<!-- servlet registration -->
	<servlet>
		<!-- Identifier for this servlet within the web container -->
		<servlet-name>HelloWorldServlet</servlet-name>
		<!-- Specify the full qualified classname of the servlet class -->
		<servlet-class>com.revature.servlet.HelloWorldServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>HelloWorldServlet</servlet-name>
		<url-pattern>/hello</url-pattern>
	</servlet-mapping>

    properties
    web project settings
    targeted runtimes -> click tomcat -> apply

create html files in the webapp folder
