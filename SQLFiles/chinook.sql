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
SET FIRSTNAME = 'Robert', LASTNAME = 'Mitchell'
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
WHERE TOTAL >= 15 AND TOTAL <= 50;

SELECT * FROM EMPLOYEE
WHERE HIREDATE >= TO_DATE('2003-06-01', 'yyyy-mm-dd') AND HIREDATE <= TO_DATE('2004-03-01', 'yyyy-mm-dd');

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

-- SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
-- Task – create a function that returns the length of name in MEDIATYPE table

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices 
-- Task – Create a function that returns the most expensive track

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoice line items in the invoiceline table

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who were born after 1968.

-- 4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
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
