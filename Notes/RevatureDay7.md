# 9/11/2019

week1
Java can be stored on a server and can be used to access Databases
with JDBC/Hibernate

week2
Databases
Stores information
Oracle SQL

week3
Client side stuff
Web-browser stuff
HTML
CSS
JAVASCRIPT- ajax, fetch

week4
learning to use JAVASCRIPT
in order to use http requests and http responses
to talk to the java server that can access Databases
servlets and angular

week5
hibernate- object relation mapping
devops- how to actually deploy everything out there in the world

week6
spring framework (java framework)
makes everything from above and making it easier

week7
webservives- rest, soap, microservices
servers talking to each other
standard means of interoperation between web applications

week8to10
panel interviews
project3

project0
java, jdbc, SQL

project1 (paired?)
full stack on your side

project2
teams will give a proposal
mentor will allow it or not

project3
working on the mentors project (HUGE)

## Databases

Plae to store presistent data
relational databases- has keys
    data is organized into tables
    has rows and cols
    table has a primary key -> unique identifier for a record
    the primary key can not be null
    tables are related with foreign keys
    foreign keys -> primary key of another table
    foreign keys don't need to be unique and they can be null

Employees Table
ID, F_NAME, L_NAME, DEPT_ID
52, GANDALF, GREY, 3
53, SARUMAN, WHITE, 3
174, FRODO, BAGGINS, 27

Department Table
ID, NAME
3, MAGIC
27, QUESTING

the primary key of Employees is ID
the primary key of Department is also ID
the foreign key is DEPT_ID, can be null, doesn't have to be unique

relational databases includes:
oracle
microsoft sql server
mysql
sql lite
postgresql

non relational databases
data is organized into json (typically) documens
mongoDB, dynamoDB

Entity Relational Diagram

Multiplicty Relationships
Credentials - User
1-1 assignment

1 to many
many to 1
exmployee to department

many to many
student to courses

many to many requires a junction/transition table
uses a composite key (cumbersome)
every key in a junction table is unique
TABLE1_TABLE2 is the name design

STUDENT ORGANIZATIONS
MEMBERS,    OFFICERS,   NAME,   MEETING TIME + LOCATION,    FACULTY ADVISOR

## Database Normalization

Arranging information into tables to reduce redundancy and enforce integrety
Avoid data manipulation issues through use of well placed foreign keys

"levels" of normalization
normal forms of a database
1-6
3NF = is typically considered sufficiently normalized

SalesStaff ( NOT NORMALIZED )
EMP_ID | EMP_NAME | OFFICE    | OFF_NUM | CUST_1 | CUST_2 | CUST_3
42       BOB        Chicago    111-1111   REV      APP
79       SUE        Brooklyn   555-5555   APP
151      FRED       Brooklyn   555-5555   BOW               REV

1NF: INFORMATION is stored in relational tables with atomic values
in each column and no repeated groups of columns

2NF: 1NF + all columns depend on PK, (no partial dependencies)

3NF: 2NF + nothing is transitively dependent on the primary key
example: AGE and BIRTHDAY

multiplicity relationships vs normal forms (don't confuse them)

RDBMS (relational database management service)

CREATE DATABASE -> STANDARD -> ORACLE -> ORACLE STADARD EDITION TWO -> DEV/TEST

admin
CoDe
