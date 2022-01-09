# JWT

Simple implementation to use JWT to secure exposed Rest APIs. Session management is stateless here which means same JWT token will be used for all the requests.

1. Post /authenticate with username and password.
    Generated JWT token.
    
2. Get / with JWT in the token.
    Return response.
