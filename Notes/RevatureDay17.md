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
