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
    BEAR_NAME VARCHAR2(100), --100 CHARACTERS OF SPACE
    --VARCHAR2 INTERPRETS NULL AND EMPTY STRING AS THE SAME VALUE, UNLIKE VARCHAR
    BIRTHDATE DATE,
    WEIGHT NUMBER(6, 2) DEFAULT 200.00,
    BEAR_TYPE_ID INTEGER NOT NULL, --APPLYING A NOT NULL CONSTRAINT TO THIS COLUMN, WILL BE FK
    CAVE_ID INTEGER --WILL BE A NULLABLE FK
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
    MAX_BEARS INTEGER DEFAULT 4
);
/

CREATE TABLE BEEHIVE (
    BEEHIVE_ID INTEGER PRIMARY KEY,
    HONEY_AMT NUMBER(5, 2) DEFAULT 75.00
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
--TYPES OF CONSTRAINTS: CHECK (INCLUDES NOT NULL), UNIQUE, PRIMARY KEY, FOREIGN KEY

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_BEAR_TYPE
FOREIGN KEY (BEAR_TYPE_ID) REFERENCES BEAR_TYPE(BEAR_TYPE_ID);
/

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_CAVE
FOREIGN KEY (CAVE_ID) REFERENCES CAVE(CAVE_ID);
/

ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEAR
FOREIGN KEY (BEAR_ID) REFERENCES BEAR(BEAR_ID);
/

ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEEHIVE
FOREIGN KEY (BEEHIVE_ID) REFERENCES BEEHIVE(BEEHIVE_ID);
/

--ADD SOME DATA - BE CAREFUL ABOUT INSERTION ORDER
--TWO WAYS TO ADD: BY FILLING ALL COLUMNS OR SPECIFY WHICH COLUMNS TO FILL

INSERT INTO BEAR_TYPE VALUES(1, 'GRIZZLY');
INSERT INTO BEAR_TYPE (BEAR_TYPE_ID, BEAR_TYPE_NAME) VALUES (2, 'SUN');

INSERT ALL
INTO CAVE
VALUES(1, 'QUEENS COLLEGE', 15)
INTO CAVE (CAVE_ID, CAVE_NAME)
VALUES(37, 'AWESOME CAVE')
SELECT * FROM DUAL; --DUAL IS A DUMMY TABLE, PLSQL USES IT TO MAKE STATEMENTS FIT THE QUERY FORMAT

SELECT * FROM CAVE;

INSERT ALL
INTO BEAR(BEAR_ID, BEAR_NAME, BIRTHDATE, BEAR_TYPE_ID, CAVE_ID)
VALUES(72, 'BARRY', TO_DATE('2000-10-08', 'YYYY-MM-DD'), 1, 37)
INTO BEAR(BEAR_ID, BEAR_NAME, BIRTHDATE, BEAR_TYPE_ID, CAVE_ID)
VALUES(2, 'BOB', TO_DATE('2000-07-31', 'YYYY-MM-DD'), 2, 37)
INTO BEAR(BEAR_ID, BEAR_NAME, BIRTHDATE, BEAR_TYPE_ID, CAVE_ID)
VALUES(8, 'BEARNEICE', TO_DATE('1980-9-08', 'YYYY-MM-DD'), 1, 1)
INTO BEAR(BEAR_ID, BEAR_NAME, BIRTHDATE, WEIGHT, BEAR_TYPE_ID, CAVE_ID)
VALUES(45, 'BEATRICE', TO_DATE('2005-10-08', 'YYYY-MM-DD'), 600.00, 1, 37)
INTO BEAR(BEAR_ID, BEAR_NAME, BIRTHDATE, BEAR_TYPE_ID, CAVE_ID)
VALUES(92, 'YOGI', TO_DATE('1958-10-08', 'YYYY-MM-DD'), 2, 1)
SELECT * FROM DUAL;

INSERT INTO BEAR(BEAR_ID, BEAR_NAME, BIRTHDATE, BEAR_TYPE_ID)
VALUES(12, 'BILL', TO_DATE('1928-9-08', 'YYYY-MM-DD'), 1);

CREATE SEQUENCE SQ_BEAR_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_BEAR_TYPE_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_CAVE_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_BEEHIVE_PK
START WITH 1000
INCREMENT BY 1;
/

--TRIGGERS: BLOCKS OF CODE THAT WILL EXECUTE IN RESPONSE TO A DML STATEMET
--(INSERT, UPDATE, DELETE)
--CAN CREATE "BEFORE" OR "AFTER" TRIGGERS
CREATE OR REPLACE TRIGGER TR_INSERT_BEAR
BEFORE INSERT ON BEAR --SPECIFY THE OPERATIO, BEFORE/AFTER/ AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_BEAR_PK.NEXTVAL INTO :NEW.BEAR_ID FROM SELECT * DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BEAR_TYPE
BEFORE INSERT ON BEAR_TYPE --SPECIFY THE OPERATIO, BEFORE/AFTER/ AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_BEAR_TYPE_PK.NEXTVAL INTO :NEW.BEAR_TYPE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BEEHIVE
BEFORE INSERT ON BEEHIVE --SPECIFY THE OPERATIO, BEFORE/AFTER/ AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_BEEHIVE_PK.NEXTVAL INTO :NEW.BEEHIVE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_CAVE
BEFORE INSERT ON CAVE --SPECIFY THE OPERATIO, BEFORE/AFTER/ AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_CAVE_PK.NEXTVAL INTO :NEW.CAVE_ID FROM DUAL;
END;
/

UPDATE BEAR
SET CAVE_ID=37
WHERE BEAR_ID=12;

--SELECT STATEMENTS

--SELECT ALL NON-GRIZZLY BEARS
SELECT BEAR_NAME, BIRTHDATE FROM BEAR
WHERE BEAR_TYPE_ID != 1
ORDER BY BEAR_NAME; -- ASCENDING IS DEFAULT, 'DESC' FOR DESCENDING ORODER

--SELECT ALL BEARS, ORDERED BY WEIGHT AND BIRTHDATE
SELECT * FROM BEAR
ORDER BY WEIGHT, BIRTHDATE;

--HOW MANY BEARS PER CAVE?
SELECT COUNT(*) FROM BEAR
WHERE CAVE_ID = 37;

SELECT CAVE_ID, COUNT(BEAR_ID) AS NUMBEAR
FROM BEAR
GROUP BY CAVE_ID;

SELECT CAVE_ID, COUNT(BEAR_ID) AS NUMBEAR
FROM BEAR
GROUP BY CAVE_ID
HAVING COUNT(BEAR_ID) > 3;