Student Portal Demo – Spring Boot Security & JWT

A backend Student Portal application built using Java, Spring Boot, Spring Security, Spring Data JPA, MySQL, and JWT. This project demonstrates secure user registration, authentication, token-based authorization, and role-based access control.

🚀 Features

- User Registration: Register students with name, email, and password.
- Spring Security: Secure application endpoints using a custom security configuration.
- BCrypt Password Hashing: Hash passwords before storing them in the database.
- JWT Authentication: Generate and validate JSON Web Tokens for authenticated requests.
- Stateless Authentication: Authenticate API requests using JWT bearer tokens instead of server-side HTTP sessions.
- Custom UserDetailsService: Load users from the database using their email addresses.
- Custom JWT Authentication Filter: Extract, validate, and process JWT tokens for incoming requests.
- Role-Based Authorization: Support separate "ROLE_STUDENT" and "ROLE_ADMIN" roles.
- Method-Level Security: Use "@EnableMethodSecurity" and "@PreAuthorize" to control access to protected methods and endpoints.
- Password Protection: Never return the stored password hash in registration responses.
- MySQL Integration: Persist user information using Spring Data JPA.
- Request Validation: Validate incoming registration data.

🛠️ Technologies Used

Technology| Purpose
Java| Backend programming
Spring Boot| Application development
Spring Security| Authentication and authorization
Spring Data JPA| Database operations
Hibernate| ORM implementation
MySQL| Relational database
JWT / JJWT 0.13.0| Token generation and validation
BCrypt| Password hashing
Jakarta Bean Validation| Input validation
Maven| Dependency management
Postman| API testing

🔐 Authentication and Authorization

1. User Registration

The registration process follows this flow:

"Client → AuthController → AuthService → UserRepository → MySQL"

- Accept user details through the registration API.
- Validate the incoming request.
- Check for an existing user with the same email.
- Hash the password using BCrypt.
- Save the user and assigned role in MySQL.
- Return an appropriate response without exposing the password hash.

Endpoint: "POST /api/auth/register"

2. User Login with JWT

The login process authenticates users using their email and password.

1. The user submits login credentials.
2. Spring Security authenticates the user through "AuthenticationManager".
3. "CustomUserDetailsService" loads the user from the database.
4. The password is verified using the configured password encoder.
5. A JWT is generated for the authenticated user.
6. The client uses the token for subsequent protected API requests.

Endpoint: "POST /api/login/login"

3. JWT Request Authentication

The application uses a custom "JwtAuthenticationFilter" to process incoming requests.

- Read the JWT from the "Authorization" header.
- Validate the token and its expiry.
- Extract the user's identity and authorities.
- Establish the authenticated security context.
- Allow or deny access based on the configured security rules.

For protected requests, include the token in Postman:

"Authorization: Bearer <your_jwt_token>"

4. Role-Based Access Control

The application supports two roles:

- ROLE_STUDENT: Access permitted student functionality.
- ROLE_ADMIN: Access authorized administrative functionality.

Authorization is enforced through Spring Security configuration and method-level security.

Example:

@EnableMethodSecurity

@PreAuthorize("hasRole('ADMIN')")

The "hasRole('ADMIN')" expression checks for the "ROLE_ADMIN" authority.

Authorization testing:

- A student token attempting to access an admin-only endpoint receives "403 Forbidden".
- An admin token can access endpoints permitted to the admin role.

📂 Main Components

The project includes the following security and persistence components:

Component| Responsibility
"AuthController"| Registration and authentication endpoints
"AuthService"| Registration logic, password hashing and authentication workflow
"SecurityConfig"| Security filter chain and endpoint access rules
"CustomUserDetailsService"| Loads users by email
"JwtAuthenticationFilter"| Validates bearer tokens for incoming requests
JWT utility/service| Generates and validates JWTs
"PasswordEncoder"| BCrypt password hashing and verification
"UserRepository"| Database access for user records
"Student" / user entity| Stores user details and roles
Request/response DTOs| Controls incoming data and API responses

⚙️ Prerequisites

- Java and a compatible JDK
- Maven
- MySQL Server
- IntelliJ IDEA or another Java IDE
- Postman

🏁 Getting Started

1. Clone the repository

git clone <[your-github-repository-url](https://github.com/Ashish4021/Spring-Security-Practice-Project.git)>
cd <your-project-folder>

2. Create the MySQL database

CREATE DATABASE student_portal;

3. Configure application properties

Configure the database connection in "src/main/resources/application.properties".

spring.datasource.url=jdbc:mysql://localhost:3306/student_portal
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Use your own local environment variables for database credentials. Configure the JWT secret through an environment variable as required by your JWT implementation.

Security note: Never commit database passwords, JWT secrets, or other credentials to GitHub.

4. Run the application

Using Maven:

mvn spring-boot:run

Alternatively, run the main Spring Boot application class from your IDE.

5. Test with Postman

1. Register a user using "POST /api/auth/register".
2. Log in using "POST /api/login/login".
3. Obtain the JWT from the login response.
4. Send the token as a Bearer token to protected endpoints.
5. Test student and admin permissions using tokens for the respective roles.

Use the actual request DTOs, response structure, and protected endpoint paths defined in the project.

🧪 Security Testing

The project was used to practice and test:

- Successful user registration and login.
- BCrypt password hashing.
- JWT generation and validation.
- Authentication of protected requests.
- Token expiration and invalid-token handling.
- Role-based access restrictions.
- Denial of unauthorized student access to admin-only endpoints.
- Authorized admin access.
- Method-level security with "@PreAuthorize".

🎯 Learning Outcomes

Through this project, I gained practical experience with:

- Configuring Spring Security for REST APIs.
- Implementing custom authentication using JWT.
- Understanding authentication versus authorization.
- Securing passwords with BCrypt.
- Implementing stateless security.
- Managing user roles and permissions.
- Using custom security filters and "UserDetailsService".
- Testing secured REST APIs using Postman.
- Integrating Spring Security with Spring Data JPA and MySQL.

👩‍💻 Project Purpose

This is a learning and demonstration project developed to strengthen practical understanding of Spring Boot Security, JWT authentication, and role-based authorization through hands-on implementation.