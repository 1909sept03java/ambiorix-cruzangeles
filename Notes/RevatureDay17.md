# 10/1/2019

## Hibernate

ORM: Object Relational Mapping (RED HAT)

Abstracts away some JDBC by establishing mappings between database entities and java classes.
Looser coupling with database, minimizes native sql. (Not depend on dialect)
This is done using HQL (Hibernate Query Language).
Syntax for writing queries that which uses the names of mapped java entities instead of table and column names.
Hibernate automatically translates between HQL and native SQL with the correct config.

Code First or DB First

org.hibernate
javax.persistence (JPA- Java Persistence API)
Base Throwable type is HibernateException

REMEMBER:
JDBC API
Connection(INTERFACE)
    Obtained from DriverManager(CLASS)
Statement(INTERFACE)
PrepareStatement(INTERFACE)
CallableStatement(INTERFACE)
ResultSet(INTERFACE)

IN HIBERNATE:
Session(I)
    Refreshes set of interactions with database
    (NOT RELATED TO HttpSession or Browser Sessions)
Important Operational Methods
get(), load(), save(), persist(), SveOrUpdate(), update(), merge(), delete(), etc.
Basic Crud Ops, methods for reating queries, cache management methods.

SessionFactory(I)
Creates sessions

create a new maven project
simple
com.revature
HibernateDemo

set up pom.xml
with hibernate stuff and ojdcb7
create a hibernate.cfg.xml

<?xml version="1.0" encoding="UTF-8"?>
<!-- specify the Document Type Definition (DTD) of a Hiberante config file -->
<!-- DTD describes what elements a file may contain to be "valid" -->
<!-- other option for validating XML files: XSD ("XML Schema Definition") -->
<!-- an XML file may be "well-formed" without being "valid" (conforming to 
	a DTD or XSD) -->
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
	<session-factory>
		<property name="hibernate.connection.driver.class">oracle.jdbc.driver.OracleDriver</property>
		<property name="hibernate.current_session_context_class">thread</property>
		<!-- convenience for development -->
		<property name="hibernate.show_sql">true</property>
		<!-- choose whether to start fresh or update existing DDL -->
		<!-- defaults to update -->
		<property name="hibernate.hbm2ddl.auto">update</property>
	</session-factory>
</hibernate-configuration>

