# 9/25/2019

## Authenticating User

Authentication ->
    Does the user exist?

Authorization ->
    What permissions do they have?

How?
    -> Session-Based (Statefull)
    -> Token-Based (StateLess)
        Better for restful architecture
        Popular: JWT (JSON Web Tokens)

in a servlet application
    HTTPSession

    -> Server-side session object capable of holding name-value pairs of info ("Attributes") about a set of user inreactions w/ your site
    not same as browser session

    -> unique JSESSIONID, stored in browser as a cooie or appended to url of requests if cookies are disabled

    -> cookie: small piece of information maintained by a client and used to identify that specific client to servers

    -> persistent cookie: sticks around between browser sessions

    -> new persistent cookie: lasts for only one browser session
