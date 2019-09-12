# 9/12/2019

SQL: Structured Query Language
General syntax to interact with databases
The SQL dialect varies depending on the database provider
The SQL dialect we will be using comes from Oracle
It is called PL/SQL - Procedural Language SQL
It is able to invoke advance procedures that may or may not be neccesary (looping, etc)
Typically SQL isn't supposed to be used to do those procedures
Sublanguages are groups of commands organized by a purpose

## Sublanguages

DDL: Data Definition Language - Structure Changing
KEYWORDS-
CREATE: CREATES THE TABLE
ALTER: CHANGE THE STRUCTURE OF THE TABLE
TRUNCATE: REMOVES ALL DATA FROM THE TABLE, TABLE REMAINS
DROP: REMOVES THE TABLE

DML: Data Manipulation Language - Data Changing
INSERT: INSERTING A ROW
UPDATE: UPDATING A ROW
DELETE: DELETING A ROW
SELECT: GOING THROUGH THE DATA

DQL: Data Query Language - Going through the data
SELECT: GOING THROUGH THE DATA

DCL: Data Control Language - Accessing the structures/tables/entities/data
GRANT: GRANT ACCESS
REVOKE: TAKE AWAY ACCESS

TCL: Transaction Control Language - Saving changes to data
COMMIT: SAVING
ROLLBACK: REVERTING BACK
SAVEPOINT: SAVEPOINT TO ROLLBACK TO
