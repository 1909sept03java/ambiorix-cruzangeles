# 10/3/2019

## Multiplicity Relationships

Where should related entry be represented?
Which entity should manage relationships?
Unidirectional or Bidirectional?
Cascades (Transitive Persistence), None, By Default

Session Methods

Basic Crud Operations via Session Object

get(int id)
Eagerly fetch obj w/ primary key matching an entry in the DB (or session cache)
returns null if not found

load(int id)
lazily fetch obj (returns proxy, throws LazyInitializationException if access proxy outside session)
throws exception if object is not found

new() -> TRANSIENT

load(), get() -> PERSISTENT

TRANSIENT <-> PERSISTENT

PERSISTENT <-> DETACHED

### Saving information

Save(Object o)
int return type -> pk of new DB entry
TRANSIENT -> PERSISTENT
original

persist(Object o)
void return type
TRANSIENT -> PERSISTENT
new

saving something that is already persistent returns exception

HQL Query also makes objects persistent

merge(Object o)
finds or creates ersistent version of o
copy values from o into persistent object
let automatic dirty checking do the rest

update(Object o)
makes detached object persistent
throws exception if passed a transient object or if a persistent version of object

saveOrUpdate(object o)
make an object which is transient or detached, persistent

### Caching

Storing information on Java Side

Level 1 ("L1")
Scoped to session
No Additional Config
event() remove one object
clear() purge entire cache
contains() check whether given object is cached

Level 2 ("L2")
scoped to sessionfactory
cache info in between sessions
use a 3rd party library (EHCACHE)
read only
not expecting info to change between sessions
read write
check for updates when new session begins

stale data + memory issues WARNING

### Isolation Problems

Dirty Read: A transaction reads uncommited data from another transaction
Non repeatable reads: Another tx modifies and commits modifications of rms being used by current tx
Phantom read: Another tx adds data matching conditions being used by current tx

                    DIRTY READ      NONREP READ      PHANTOM READ
READ UNCOMMITED         YES             YES                 YES
READ COMMITED           NO              YES                 YES
REPEATABLE READ         NO              NO                  YES
SERIALIZABLE            NO              NO                  NO

FAST
TO
SLOW
