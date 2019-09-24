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

File -> New -> Other -> Server -> Apache -> Tomcat 9 -> local host and Tomcat v9.0 Server at localhost ->