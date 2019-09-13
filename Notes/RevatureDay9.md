# 9/13/2019

## System Deamed Functions

Scaler vs Aggregate
UCASE()     MIN()
LCASE()     MAX()
NBW()       AVG()
ROUND()     SUM()
FORMAT      COUNT()
LEN()

operates on single value, returns single value

performing and operation based on multiple values in a column and returns a sigle value

## PL/SQL

extends SQL to include blocks of procedural code

LOOPS
CONDITIONALS
DECLARE VARIABLES
ERROR HANDLING

## To Save and Reuse SQL statements

views
virtual table
Result set of a saved select statement

functions
saved blocks of code
take 0 or many params
return 1 value
DQL ONLY

stored procedures
saved blocks of code
take 0 or many in params
return 0 or many out programs
full DML + TCL

## Transactions

unit of work done on a database
Atomicity - All or nothing. The entire transaction executes or none of it does.
Consistency - DB state is valid after the transaction completes.
Isolation - Concurrent transactions execute as if they were sequential
Durability - All commits are final. When you commit, you're not rolling back.

## JDBC - Java Database Connectivity

java.sql package
SQLException -> main throwable type
throwable being the main interface
it is a checked exception, so there will need to be a try-catch-finally block

interfaces of JDBC
Connection - Represents a connection to the database
-allows us to executre sql statements and receive result sets
-maintains information about the database itself
-setAutoCommit() (TRUE by default)

OTHER INTERFACES
Statement
-takes a string and executes it as a sql command
-be very careful: sql injection
PreparedStatement
-extends Statement, executes a precompiled sql statement
-efficient for frequent queries, repeated queries, etc
-use placeholders for variables- safer

PreparedStatement pstmnt = conn.prepareStatement("SELECT * FROM BEAR WHERE NAME = ?");
pstmnt.setString(1, "Bob");

CallableStatement

ResultSet
