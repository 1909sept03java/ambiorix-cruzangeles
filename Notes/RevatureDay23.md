# 10/10/2019

## Spring ORM (Object Relational Mapping)

Module for integrating an ORM framework (like hibernate) with spring

Condense config into just spring configuration
- no longer have a hibernate.cfg.xml

sessionfactory -> bean

@Repository
-> Spring Stereotype
-> indicates that a class contains data access code
-> tells PersistenceExceptionTranslationPostProcessor that bean will throw DataAccessExceptions

@Transactional
-> Unify transaction with dao methods
-> we don't have to manually begin/commit/rollback because those are coupled with a method outcome
