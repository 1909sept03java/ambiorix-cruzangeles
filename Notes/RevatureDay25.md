# 10/15/2019

## SOAP

"Simple Object Access Protocol"

Communication protocol for constructing web services
Platform-independent and language-agnostic
(written in whatever and hosted by whatever)
aslong as whatever is living on the servers is following
the rules of SOAP, then they should all work properly
and be able to communicate easily
(just like in a restful architecture)
Request-Response messaging pattern
Can be stateless

## SOAP vs REST

SOAP-
Communication Protocol
Can use HTTP, SMTP, and some other
xml formatted messages
normally a post (can do it in get but just don't)
it is contract based (WSDL)
"Web Service Definition Language"

REST-
Architectural Style
Http(s) only
JSON, plain text, xml, no assumption made
rely on the endpoint structure
(what urls and what verbs are allowed and documentation)

## WSDL ("Web Service Definition Language")

xml document
which defines the "contract"
-> What operations are available?
-> How must messages be formatted to invoke those operations?
