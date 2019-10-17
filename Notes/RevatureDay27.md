# 10/17/2019

## 9:15 am stand up

## Splitting up into groups

1) Centralized Configuration with Spring Cloud Config
(1 service has all the configurations, so you don't have to
go to each individual service to change configurations,
you just need to go into one central location and change
the configuration there, the other services will fetch
that configuration from the central config service)

2) Circuit breaking with Hystrix (why we care and cascading failures)

3) Load balancing with Ribbon (Zuul filters and filters in Spring Cloud)

Find your group and do some research.  
Create a small presentation on the topics.  

## Making a Cetralized Config Service

1) Make a basic User Service ( just a small spring boot application)

2) Move configuration for functional services to centralized config service (Github)
- the user service will use the configuration stored on github to build itself

3) messaging concept (amqp with rabbitMq)
- 4:30 pm, we started doing board notes on this, see below

4) Send Rabbit Broker (tomorrow)

5) Include publish and subscribing to queue in msa (tomorrow)

## Communication between Services

-> direct messaging using RestTemplate or FeignClient

-> limits to 1 request and 1 response pattern (1 message, 1 reply)

-> tight coupling

-> packet loss

What about a messaging queue?

(Producers)
There will be a "publisher" that has a message to send to the queue of messages

(Consumers)
There will be a lot of "subscribers" that subscribe to the queue and are regularly
checking for new messages

(Broker)
The broker is the queue itself

## AMQP

Advanced Messaging Queue Protocol

Specification for achieving a messaging queue

RabbitMQ follows this protocol
it is integrated with Spring Project and Spring AMQP

Not just for JAVA. Other applications can push to it too.

As a contrast to JMS, JAVA messaging service- another API
for messaging between apps.
