/* PLSQL script written for Project 1 - Reimbursement */
/* created by Ambiorix Cruz Angeles */
/* The idea behind this is to have an Employee Table */
/* and a Reimbursement Table, where the Employee Table */
/* contains a column that determines who is a manager */
/* as well as a column that says which Employee is managed */
/* by that manager */

/* dropping the tables incase the script needs to be re-run */
DROP TABLE EMPLOYEES;
/
DROP TABLE REIMBURSEMENTS;
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