# 10/16/2019

## Root Definitions

types -> any complex types that will be used in this service
message -> a abstract type definition of data being communicated
operation -> a description of an action available via the service
prototype -> a set of operations
binding -> specifies data format and protocol for a portype
    style: document or RPC
        document refers to the structure of the soap body anyway, as long as its xml
        rpc refers to specifying specific operations and parameter list
    use: literal or encoded
        literal body forms to user defined xml schema
        encoded body doesn't conform to user defined xml schema
        document literal is usually default
port -> endpoint defined by a binding network address
service -> collection of related endpoints

Dang the Pizza man put on big shoes

## Monolith

Entire application (all layers and all behaviours) is in one codebase
-> dificult to scale
-> code complexity is high, deployment complexity is low

SOA (Service Oriented Architecture)
Break up application into reusable pieces
Share as much as possible between pieces
Services can act as providers or consumers or communicate often via ESB
(enterprise service bus)

## microservices

Break up application into lightweight, independent, single-responsibility
services (that share as little as possible)
popularized by netflix

Often distributed noSQL databases
BASE vs ACID
Basic availability
Soft state
Eventual consistency

Services are not aware of eacch other, but are aware
of discovery service

Service Registry
-> Performs service discovery by receiving "heartbeats"
from active services
-> we'll use Eureka from from netflix
