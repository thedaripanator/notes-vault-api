# 🔐 Secure Notes Backend

A Spring Boot–based backend application that allows users to securely create and manage personal notes. The project follows a clean layered architecture and implements role-based access control for admin operations.

---

## 🚀 Features

- 📝 Create, update, delete, and fetch notes  
- 👤 User management system  
- 🔐 Role-based access control (USER / ADMIN)  
- 🧩 Clean architecture (Controller → Service → Repository)  
- 🗄️ MySQL database integration using JPA/Hibernate  
- ⚡ RESTful API design  

---

## 🏗️ Tech Stack

- Backend: Spring Boot  
- Language: Java  
- Database: MySQL  
- ORM: Hibernate (JPA)  
- Build Tool: Maven  
- Security: Spring Security  

---

## 📁 Project Structure

```bash
secure-notes/
├── controller/        # REST controllers (Notes, Admin)
├── service/           # Business logic interfaces
├── serviceimpl/       # Service implementations
├── repository/        # JPA repositories
├── model/             # Entity & DTO classes
├── config/            # Security configuration
└── SecureNotesApp.java

## ⚙️ Setup & Installation

### Prerequisites

Make sure you have the following installed:

- Java 17 or higher  
- Maven  
- MySQL Server  
- Git  

---

### 1. Clone the Repository

git clone https://github.com/thedaripanator/secure-notes.git  
cd secure-notes  

---

### 2. Setup MySQL Database

Login to MySQL and create a database:

CREATE DATABASE secure_notes;

---

### 3. Configure Application Properties

Open `src/main/resources/application.properties` and update:

spring.datasource.url=jdbc:mysql://localhost:3306/secure_notes  
spring.datasource.username=your_username  
spring.datasource.password=your_password  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  

---

### 4. Build the Project

mvn clean install  

---

### 5. Run the Application

mvn spring-boot:run  

---

### 6. Access the API

Server will start at:

http://localhost:8080  

You can test APIs using Postman or any REST client.

---

## 📡 API Endpoints

### 📝 Notes API (Authenticated Users)

| Method | Endpoint              | Description                     |
|--------|----------------------|---------------------------------|
| POST   | /api/notes           | Create a new note               |
| GET    | /api/notes           | Get all notes for logged user   |
| PUT    | /api/notes/{id}      | Update a note                   |
| DELETE | /api/notes/{id}      | Delete a note                   |

---

### 👑 Admin API (ROLE_ADMIN only)

| Method | Endpoint                        | Description                          |
|--------|--------------------------------|--------------------------------------|
| GET    | /api/admin/getusers            | Retrieve all users                   |
| GET    | /api/admin/user/{id}           | Get user details by ID               |
| PUT    | /api/admin/update-role         | Update user role (ADMIN / USER)      |

---

## 🔐 Authorization

- /api/notes/** → Accessible to authenticated users  
- /api/admin/** → Restricted to users with ROLE_ADMIN  

Example:

@PreAuthorize("hasRole('ROLE_ADMIN')")

---

## 🧠 What This Project Demonstrates

- Spring Boot layered architecture  
- Proper use of JPA repositories  
- MySQL database integration  
- Role-based authorization using Spring Security  

---

## 🚧 Future Improvements

- JWT-based authentication  
- Password encryption using BCrypt  
- Request validation (@Valid)  
- Global exception handling (@ControllerAdvice)  
- Note encryption  

---

## 👨‍💻 Author

https://github.com/thedaripanator  

---

## ⚠️ Note

This project currently implements basic role-based security. Advanced features like JWT authentication and encryption are planned.
