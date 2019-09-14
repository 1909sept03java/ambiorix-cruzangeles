-- AMBIORIX CRUZ ANGELES
-- SQL LAB HW ASSIGNMENT

-- 2.1 SELECT
-- Task – Select all records from the Employee table.
-- Task – Select all records from the Employee table where last name is King.
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = 'NULL';

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
-- Task – Select first name from Customer and sort result set in ascending order by city

SELECT * FROM ALBUM
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table 
-- Task – Insert two new records into Employee table
-- Task – Insert two new records into Customer table

-- SELECT * FROM GENRE;
-- The Genre table already has 25 genre's in it
-- So insert into row 26+

INSERT INTO GENRE(GENREID, NAME)
VALUES (26, 'Rap');

INSERT INTO GENRE(GENREID, NAME)
VALUES (27, 'Drum and Bass');

-- SELECT * FROM EMPLOYEE;
-- The Employee table already has 8 employee's in it
-- So insert into row 9+

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Cruz Angeles', 'Ambiorix', 'President', 1, TO_DATE('1946-12-28', 'YYYY-MM-DD'), TO_DATE('1946-12-29', 'YYYY-MM-DD'), '229 Imaginary Road', 'Yonkers', 'NY', 'United States', '10701', '+1 (999) 999-9998', '+1 (999) 999-9999', 'ambiorix@chinookcorp.com');

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Cruz', 'Rex', 'Co-President', 1, TO_DATE('1946-11-28', 'YYYY-MM-DD'), TO_DATE('1946-11-29', 'YYYY-MM-DD'), '230 Imaginary Road', 'Yonkers', 'NY', 'United States', '10701', '+1 (999) 999-9997', '+1 (999) 999-9996', 'rex@chinookcorp.com');

-- SELECT * FROM CUSTOMER;
-- The Customer table already has 59 customer's in it
-- So insert into row 60+

INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Rick', 'Sanchez', 'IDGAF', '213 Earth', 'Quahog', 'NY', 'United States', '10101', '+1 (201) 230-3003', '+1 (203) 302-0303', 'rick@idgaf.com', 3);

INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Morty', 'Sanchez', 'IDGAF', '214 Earth', 'Quahog', 'NY', 'United States', '10102', '+1 (201) 230-3023', '+1 (203) 312-0303', 'morty@idgaf.com', 3);

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

-- SELECT * FROM CUSTOMER;

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32; -- Aaron Mitchell's CUSTOMERID

-- SELECT * FROM ARTIST;

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%” 

SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' and '01-MAR-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

-- right click on customer table in connections tab, disable constraints, delete customer Robert Walter, enable constraints
-- ERROR integrity constraint (CHINOOK.FK_INVOICECUSTOMERID) violated - child record found

SELECT * FROM CUSTOMER;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.

CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP IS
T TIMESTAMP;
BEGIN
    T := SYSDATE;
    RETURN(T);
END;
/
SELECT GET_TIME() FROM DUAL;

-- Task – create a function that returns the length of name in MEDIATYPE table

CREATE OR REPLACE FUNCTION GET_NAME_LENGTH(M_ID IN NUMBER)
RETURN NUMBER IS
L NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO L FROM MEDIATYPE WHERE MEDIATYPEID = M_ID;
    RETURN(L);
END;
/
SELECT GET_NAME_LENGTH(1) FROM DUAL;

-- 3.2 System Defined Aggregate Functions

-- Task – Create a function that returns the average total of all invoices 

CREATE OR REPLACE FUNCTION GET_AVG_INVOICE_TOTAL
RETURN NUMBER IS
AVG_INVOICE_TOTAL NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO AVG_INVOICE_TOTAL FROM INVOICE;
    RETURN(AVG_INVOICE_TOTAL);
END;
/
SELECT GET_AVG_INVOICE_TOTAL() FROM DUAL;

-- Task – Create a function that returns the most expensive track

CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER IS
EXP_TRACK NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO EXP_TRACK FROM TRACK;
    RETURN(EXP_TRACK);
END;
/
SELECT MOST_EXPENSIVE_TRACK() FROM DUAL;

-- 3.3 User Defined Scalar Functions

-- Task – Create a function that returns the average price of invoice line items in the invoiceline table

CREATE OR REPLACE FUNCTION AVG_INVOICELINE_UNITPRICE
RETURN NUMBER IS
AVG_UNITPRICE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_UNITPRICE FROM INVOICELINE;
    RETURN(AVG_UNITPRICE);
END;
/
SELECT AVG_INVOICELINE_UNITPRICE() FROM DUAL;

-- 3.4 User Defined Table Valued Functions

-- Task – Create a function that returns all employees who were born after 1968.

CREATE OR REPLACE FUNCTION EMPLOYEES_AFTER_1968
RETURN SYS_REFCURSOR IS
EMPLOYEES_AFTER SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEES_AFTER FOR
    SELECT * FROM EMPLOYEE
    WHERE BIRTHDATE > '01-JAN-1968';
    RETURN EMPLOYEES_AFTER;
END;
/
SELECT EMPLOYEES_AFTER_1968 FROM DUAL;

-- 4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

-- 4.1 Basic Stored Procedure

-- Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE GET_NAMES(S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
SET SERVEROUTPUT ON
DECLARE
    S SYS_REFCURSOR;
    FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
    LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_NAMES(S);
    LOOP
        FETCH S
        INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' || LAST_NAME);
    END LOOP;
    CLOSE S;
END;
/

-- 4.2 Stored Procedure Input Parameters

-- Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_LASTNAME IN EMPLOYEE.LASTNAME%TYPE,
    E_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE,
    E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    E_CITY IN EMPLOYEE.CITY%TYPE,
    E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    E_PHONE IN EMPLOYEE.PHONE%TYPE,
    E_FAX IN EMPLOYEE.FAX%TYPE,
    E_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = E_LASTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FIRSTNAME = E_FIRSTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET ADDRESS = E_ADDRESS WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET CITY = E_CITY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET COUNTRY = E_COUNTRY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET POSTALCODE = E_POSTALCODE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET PHONE = E_PHONE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FAX = E_FAX WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET EMAIL = E_EMAIL WHERE EMPLOYEEID = E_EMPLOYEEID;
    COMMIT;
END;
/
EXECUTE UPDATE_EMPLOYEE_INFO(10, 'Cruz', 'Rex2', '230 Imaginary Road', 'Yonkers', 'United States', '10701', '+1 (999) 999-9997', '+1 (999) 999-9996', 'rex@chinookcorp.com');


-- Task – Create a stored procedure that returns the managers of an employee.

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
 
-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

-- 7.0 JOINS
-- In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
