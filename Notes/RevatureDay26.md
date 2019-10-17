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

Functional Services
-> support business requirements

Infrastructure Services
-> other features of
    ecosystem (registry)
    discovery, routing,
    messaging, logging,
    monitoring, security, etc

MSA, continued
Scaling
-> adapting capacity of system to match traffic/computing needs
vertical -> increasing or decreasing the size of individual instances of a service
horizontal -> increasing or decreasing the number of instances of a service

Goal: conceal MSA behind a simple, uniform api

my~application.com /billing /streaming /user-profile

Gateway: provides point of access in MSA
performs filtering, auth, load balancing, distribution req's, between different instances of same service

gateway talks to service registry

flashcard service (spring boot)
functional service

discovery service (spring boot)
service repository

flashcard gate that encompasses both services
spring boot app
api gateway
