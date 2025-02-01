# Points learned

### Spring boot Basic Authentication

#### Introduction

Basic Authentication, while not recommended for production-ready applications due to significant security concerns (
e.g., plain-text passwords without encryption or hashing,
reliance on simple base64 encoding, use of predefined users, etc.), serves as a straightforward
way to understand the fundamental concepts and architecture of Spring Security. This approach can help illustrate key
features, such as user authentication, authorization, and the configuration of a basic security framework.

* Override the default basic authentication.
* Create a user, password and authority and buildup the UserDetailsService bean (one of the most important components).
* using in memory InMemoryUserDetailsManager to store the user in the Application memory.
* configure Simple (NoOpPasswordEncoder) Password encoder bean which is the second most important component for
  Authentication
* Add method specific Authentication and Authorization.
* configure public and private endpoints.
* Adding custom Authentication provider.