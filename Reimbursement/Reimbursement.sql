/* PLSQL script written for Project 1 - Reimbursement */
/* created by Ambiorix Cruz Angeles */
/* The idea behind this is to have an Employee Table */
/* and a Reimbursement Table, where the Employee Table */
/* contains a column that determines who is a manager */
/* as well as a column that says which Employee is managed */
/* by that manager */

/* dropping the tables incase the script needs to be re-run */
DROP TABLE REIMBURSEMENTS;
/
DROP TABLE EMPLOYEES;
/

/* creating the tables */
CREATE TABLE EMPLOYEES (
    EMPLOYEE_ID INTEGER PRIMARY KEY, -- primary key
    EMPLOYEE_USERNAME VARCHAR2(20), -- username login credential
    EMPLOYEE_PASSWORD VARCHAR2(20), -- password login credential
    EMPLOYEE_EMAIL VARCHAR2(20), -- email for bonus points
    EMPLOYEE_MANAGER_ID INTEGER -- all managers are employees
);
/

CREATE TABLE REIMBURSEMENTS (
    REIMBURSEMENT_ID INTEGER PRIMARY KEY, -- primary key
    REIMBURSEMENT_BALANCE NUMBER(6,2), -- reimbursement amount $9,999.99
    REIMBURSEMENT_STATUS CHAR(1) CHECK (REIMBURSEMENT_STATUS IN ('A', 'D', 'P')), -- variable A=Allowed, D=Denied, P=Pending
    EMPLOYEE_ID INTEGER REFERENCES EMPLOYEES(EMPLOYEE_ID) -- foreign key to employees table
);
/

/* creating sequences for primary keys */
DROP SEQUENCE EMPLOYEES_SEQUENCE;
/
CREATE SEQUENCE EMPLOYEES_SEQUENCE
MINVALUE 1
MAXVALUE 1000
START WITH 1
INCREMENT BY 1;
/
DROP SEQUENCE REIMBURSEMENTS_SEQUENCE;
/
CREATE SEQUENCE REIMBURSEMENTS_SEQUENCE
MINVALUE 1
MAXVALUE 1000
START WITH 1
INCREMENT BY 1;
/

/* inserting some data into the tables */
INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD, EMPLOYEE_EMAIL, EMPLOYEE_MANAGER_ID)
VALUES(EMPLOYEES_SEQUENCE.NEXTVAL, 'REX13', 'REXPASS', 'REX@EXAMPLE.COM', 0);
/

INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD, EMPLOYEE_EMAIL, EMPLOYEE_MANAGER_ID)
VALUES(EMPLOYEES_SEQUENCE.NEXTVAL, 'BILL12', 'BILLPASS', 'BILL@EXAMPLE.COM', 1);
/

INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD, EMPLOYEE_EMAIL, EMPLOYEE_MANAGER_ID)
VALUES(EMPLOYEES_SEQUENCE.NEXTVAL, 'BOB15', 'BOBPASS', 'BOB@EXAMPLE.COM', 1);
/

INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMPLOYEE_USERNAME, EMPLOYEE_PASSWORD, EMPLOYEE_EMAIL, EMPLOYEE_MANAGER_ID)
VALUES(EMPLOYEES_SEQUENCE.NEXTVAL, 'MAN16', 'MANPASS', 'MAN@EXAMPLE.COM', 0);
/