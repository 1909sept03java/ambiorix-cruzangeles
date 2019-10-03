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
