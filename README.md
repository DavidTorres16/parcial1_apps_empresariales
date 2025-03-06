# Project Name: Parcial 1 Demo Application

## Description
This project is a Java 17 Spring Boot application that implements a REST API using a layered architecture. It includes MySQL as the database and Adminer as a database management tool, all orchestrated using Docker Compose.

## Technologies Used
- **Backend:** Java 17, Spring Boot
- **Database:** MySQL
- **Database Management:** Adminer
- **API Documentation:** Springdoc OpenAPI (Swagger UI)
- **Containerization:** Docker & Docker Compose

## Project Structure
```
com.example.demo
│── controllers      # Handles HTTP requests
│── dto             # Data Transfer Objects
│── models          # Entity models
│── repositories    # Database access layer
│── services        # Business logic layer
│── DemoApplication # Main entry point of the application
```

## Prerequisites
To run this project, ensure you have the following installed:
- Java 17
- Maven
- Docker & Docker Compose

## Installation & Setup
### 1. Clone the repository
```bash
git clone https://github.com/DavidTorres16/parcial1_apps_empresariales.git
cd parcial1_apps_empresariales
```

### 2. Run the application using Docker Compose
```bash
docker-compose up --build
```
This will start the application, MySQL database, and Adminer.

### 3. Access the services:
- API: `http://localhost:4500/api/`
- Swagger UI: `http://localhost:4500/swagger.html`
- Adminer: `http://localhost:8000/` (Use MySQL credentials from `application.properties`)

## Environment Configuration
The application uses the following properties:
```properties
spring.application.name=demo
server.port=4500
server.servlet.context.path=/api/

# Swagger UI
springdoc.swagger-ui.path=/swagger.html
springdoc.swagger-ui.enabled=true
springdoc.api-docs.enabled=true

# Database setup
spring.datasource.url=jdbc:mysql://localhost:5500/taller_db?serverTimezone=UTC
spring.datasource.username=taller_user
spring.datasource.password=taller_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate (JPA) setup
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

## Contact
For inquiries or support, contact **David Mauricio Torres** at dmtg16@hotmail.com.

