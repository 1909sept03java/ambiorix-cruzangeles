# 10/8/2019

## Spring

Created in 2002 by PIVOTAL
It is a dependency injection framework
Dependency injection is a way to achieve inversion of control (IOC see below)
Dependency just means a resource that will be used
Injection is just passing the resource to a dependent entity
pros: writing more modular and loosely coupled code
      less "boiler plate" code
cons: more initial configuration needed to set it up properly

## Core of a Spring Application

ApplicationContext (interface in java)
"Spring Container" or "IoC Container"
This is where the application creates and stores all of the dependencies (Spring Beans)
Spring Beans are just Java objects whose lifecycle is managed by Spring

## Spring Modules

They support different features of an enterprise Java application
1) Spring Core
2) Spring Beans
The above modules provide the basic features
3) Spring Context
This is where we get the ApplicationContext interface that will take over the beans
Number 3 also includes the Core and the Beans themselves
4) Spring MVC (Model View Controller)
This is where Spring handles the servlets for you
This is also the presentation layer (AKA Servlets)
5) Spring AOP (Aspect Oriented Programming) or Spring REST (Let's you skip some stuff)
Allows for the injection of code into the application
if this method gets called, check this condition, etc
6) Spring ORM (Object Relational Mapping)
This is used to write our daos and create the persistence layer
7) Spring TEST
8) Spring SECURITY
9) Spring Projects
This includes Spring Boot
It allows you to spin up web applications very quickly
It packages them as jars but it contains an embedded server
that can be spun very quickly
10) Spring DATA
Designed to go along with Spring Boot
It is a major abstraction of your persistence layer
11) Spring CLOUD
Allows you to set up distributed systems
Works with cloud resources

## Spring Configuration

Application setup is very important
1) There is a spring configuration file (usually called beans.xml, doesn't have to be beans.xml just be consistent)
2) JAVA Based configuration where you have a class that is annotated with @Configuration

Example-

@Configuration
Public Class Whatever { // code here }

End Example-

In this case you can do both a beans.xml and use annotations
What goes inside the beans.xml or annotations?
Bean Definitions or Bean Recipes
What objects should be treated as beans
What objects do we want spring to manage for us
How they are related (bean wiring or AUTO wiring)
Can be explicit with bean wiring

It is not neccesary to define everything within the config files
All of the bean definition is not neccesary
Annotations can be used to set up the packages to be scanned
This is called "Component Scanning"

## Dependency Injection Styles

injections
setter injection
constructor injection (can't create the object unless all dependencies are resolved)
interface injection (not supported by spring)
field injection (not best practice since it breaks encapsulation)

is different from bean wiring

ways to wire beans
explicitly
auto wiring (by name or type)

## Bean Scopes

Singleton-
one instance per ApplicationContext
default scope of a spring bean

Prototype-
new instance is created every time bean is requested from the IoC container

Other Scopes-
(On web applications)

Request- 1 per HttpRequest
Session- 1 per HttpSession
GlobalSession- for Portlets
Application - 1 per ServletContext of DispatcherServlet
Websocket

## ApplicationContext vs BeanFactory

ApplicationContext- (Interface)
newer, comes with spring-context
superset of beanfactory
eagerly instanciates our singleton scoped beans
more time to start application, but faster to access beans during applications lifetime
ClassPathXmlApplicationContext (used this morninig)
FileSystemXmlApplicationContext
XmlWebApplicationContext (for web-aware projects)

BeanFactory-
older, original element of framework
Sophisticated Implementation of factory which lazily instantiates beans based on
provided bean recipes

POJO (Java Classes) --------------------------------> | IoC Container      | ----> Fully Functional Application
CONFIGURATION (METADATA, xml or annotations) -------> | APPLICATIONCONTEXT |

## Stereotype

Annotation which can be applied to a class to register it as a spring bean
@Component      // general, this is a bean <contex:component_scan base-package="beanHere"></>
@Repository     // put these on daos
@Service        // services obviously
@Controller     // specific urls and http method endpoints
@RestController //

## Spring Bean Life Cycle

Request Bean from Application Context (ac.getbean or app startup)
        |
Instantiation
        |
Populate Properties
        |
BeanNameAware
.setBeanName()
        |
BeanFactoryAware
.setBeanFactory
        |
Pre-Initialization
BeanPostProcessors
        |
InitializingBean
.afterPropertySession()
        |
Custom Init Methods
        |
Post-Initialization
BeanpostProcessors
        |
Bean is ready

Container Shuts Down
        |
DisposableBean
.destroy()
        |
Custom Destroy Methods
        |
Bean is dead/done

#### Project 2

In project folder, inside p2, create a folder with team name
doc inside with member list, choose a capain
start a list of user stories

## General

### Design Patterns

Inversion of Control-
something else is calling your code
you give control of your application to a framework
follows the hollywood principle
"don't call us, we'll call you"
the framework will take your code and do something with it then return it back to you

Service Locator-
pretty much what we've been doing up to this point
application has to go out and find all the resources that it needs
the application is responsible for being in the driver seat
we include jars that contain a bunch of classes and methods
