# authenticationproject
This project is a complete application built with Spring Boot. In this implementation, Spring Boot is utilized on the frontend, while MySQL (through XAMPP) serves as the database. A REST API has been integrated to provide specific data access for unauthorized users. User authentication is managed using Spring Security, ensuring that system access is restricted until users log in. Additionally, users can sign up through a REST API endpoint designed for this purpose.

Signup Url:
http://localhost:8080/req/user/create

After Login Accessable Url:
1. http://localhost:8080/index
2. http://localhost:8080/show/id
3. http://localhost:8080/edit/id

What I used in this project?

## Description:
 1. Spring Security : For secure login/logout and role-based access control
 2. HttpSession:  For session tracking across user interactions
 3. MySQL (or XAMPP): Database integration via Spring Data JPA
 4. User registration, data entry, edit, view, and delete (CRUD) functionality
 5. Thymeleaf or HTML/CSS frontend for UI rendering
 6. Form validation, input sanitation, and session timeout handling


## Tech Stack:
Backend: Spring Boot, Spring Security, Spring MVC, Spring Data JPA
Frontend: Thymeleaf (or HTML/CSS), Bootstrap, JavaScript
Database: MySQL (via XAMPP)
Tools: Visual Studio, Postman (for api testing), Git

