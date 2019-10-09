# 10/9/2019

## GitHub Branching

git checkout [branch name]
    switch to that branch
add -b after checkout
    create a branch with that name and switch you to it

ALWAYS CHECK WHAT BRANCH YOU'RE ON

GIT STATUS

git push -u origin [branch name]

## logging

This is not spring related

It is the event of logging information withing an application
it could be information or errors

LOG4J
Logpack
SLF4

where to log?
-file
-console
-somewhere else?
what to log?
format for log entries?

Log4J levels

TRACE
DEBUG
INFO
WARN
ERROR
FATAL

goes from top to bottom, so if only error is used then error and fatal are logged

## Spring AOP

allows integration of "aspect oriented programming"
Recall that in oop, the basic unit of programmability is the object

aspect -> "Cross-Cutting Concern"
not related to business requirements but supports stable and
manageable operation of the application
logging, security, etc

in Spring AOP
organize related methods supporting an "aspect" into classes annotated with @Aspect
can specify where and when methods should be executed

AspectJ
A library used by Spring AOP (Spring is not an AOP framework)

Join Point ->
Point in your application where code will be injected (usually method executions)

Advice ->
The code injection at a join point
Defined in methods in a class with @Aspect annotation
Modeled as interceptors around Join Point
3 Types-

Before
AfterReturn/AfterThrowing
Around -> most powerful type, decides whether JP executes
method takes a proceedingJoinPoint argument

PointCut ->
program element specifying where advice may be applied

Predicate -> "pointcut expression"
can specify by class
by method signature
by exection thrown

## Spring MVC

Module for constructing web aware spring applications
goal: accept http requests and return responses as either views or data or static resources
