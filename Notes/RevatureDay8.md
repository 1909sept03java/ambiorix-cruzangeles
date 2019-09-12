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
SELECT [COLUMN LIST]    // required
FROM [TABLE LIST]       // required
WHERE [CONDITION]
GROUP BY [COLUMN LIST]  // AGGREGATION
HAVING [CONDITION]      // AGGREGATION
ORDER BY [COLUMN LIST]  // DISPLAY ORDER

GROUP BY doesn't need having, HAVING needs group by.
SELECT DEPT_ID FROM EMPLOYEE GROUP BY DEPT_ID
returns  distinct values of dept_id
HAVING allows filtering of results
GROUP BY VS ORDER BY is a common interview question

DCL: Data Control Language - Accessing the structures/tables/entities/data
GRANT: GRANT ACCESS
REVOKE: TAKE AWAY ACCESS

TCL: Transaction Control Language - Saving changes to data
COMMIT: SAVING
ROLLBACK: REVERTING BACK
SAVEPOINT: SAVEPOINT TO ROLLBACK TO

JOINS ARE USED TO COMBINE INFORMATION FROM MULTIPLE TABLES on a particular column
INNER JOIN returns all non null rows and joins two tables with FK and PK
FULL JOIN is all of the records
LEFT OUTER JOIN shows everything from left to right including nulls
RIGHT OUTER JOIN shows everything from right to left and may not include nulls included in left table

## Some PL/SQL Notes

--DB CREATION SCRIPTS OFTEN BEGIN WITH DROP STATEMENTS
--AVOID CLASHES WITH EXISTING TABLES

DROP TABLE BEAR;
/
DROP TABLE BEAR_TYPE;
/
DROP TABLE CAVE;
/
DROP TABLE BEEHIVE;
/
DROP TABLE BEAR_BEEHIVE;
/

--TABLE CREATION WITH PRIMARY KEYS

CREATE TABLE BEAR (
    BEAR_ID INTEGER PRIMARY KEY,
    BEAR_NAME VARCHAR2(100), --100 CHARACTER OF SPACE
    --VARCHAR2 INTERPRETS NULL AND EMPTY STRING AS THE SAME VALUE, UNLIKE VARCHAR
    BIRTHDATE DATE,
    WEIGHT NUMBER(6, 2) DEFAULT 200.00,
    BEAR_TYPE INTEGER NOT NULL --APPLYING A NOT NULL CONSTRAINT TO THIS COLUMN, WILL BE A FOREIGN KEY
    CAVE_ID INTEGER -- WILL BE A NULLABLE FOREIGN KEY
);
/

CREATE TABLE BEAR_TYPE (
    BEAR_TYPE_ID INTEGER PRIMARY KEY,
    BEAR_TYPE_NAME VARCHAR2(100)
);
/

CREATE TABLE CAVE (
    CAVE_ID INTEGER PRIMARY KEY,
    CAVE_NAME VARCHAR2(100),
    MAX_BEARS INTEGER DEFAULT 4,
);
/

CREATE TABLE BEEHIVE (
    BEEHIVE_ID INTEGER PRIMARY KEY,
    HONEY_AMT NUMBER(5, 2) DEFAUL 75.00
);
/

CREATE TABLE BEAR_BEEHIVE (
    BEAR_ID INTEGER,
    BEEHIVE_ID INTEGER,
    PRIMARY KEY (BEAR_ID, BEEHIVE_ID) --COMPOSITE PRIMARY KEY
);
/

--FOREIGN KEY CONSTRAINTS

--CONSTRAINT: RULE PLACED ON THE CONTENTS OF A TABLE, LIMITING WHAT MAY BE INSERTED
--TYPES OF CONSTRAINTS: CHECK (INCLUDES NOT NULL), UNIQUE, PRIMARY KEY, FOREGIN KEY

## SQL LAB

due 5 pm monday sept 16th
setting up a test data base with a bunch of information from
