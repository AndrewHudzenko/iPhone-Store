# ****📽️iPhone Store App Project📽️**** #

## 🚀 Description
This is a simple version of the iPhone store app written on Spring Boot. \
You can send various HTTP requests(GET, POST, PUT, DELETE) \
to add or receive some info. \
The app also manages risk and automatically deletes unpaid orders 10 minutes after they are created.

## 🚀 Project structure
**The project has an N-Tier Architecture**
- Controller - This level allows the user to work with this application.
- Service - This level of architecture is responsible for processing the data received from the repositories level.
- Repository - This level of architecture is responsible for communicating with the database provided by Spring Boot.
- MySQL database.

## 🚀 Features
- Registration
- Authentication
- Login / Logout
- Manage risk
- Set role for each user
- MANAGER can create and delete products
- CLIENT can buy a products
- Access configuration by HTTP methods and Role
``` java
    GET: /products - CLIENT/MANAGER
    DELETE: /products - MANAGER
    PUT: /products/{id} - MANAGER
    ...
```

## 🚀 Technologies
- Java 11
- Spring Boot
- Maven
- MySQL
- Tomcat
- Hibernate
- Spring Web/Security

## 🚀 Quickstart
1. Fork this repository
2. Copy link of project
3. Create new project from Version Control
4. Edit resources/db.properties - set the necessary parameters
``` java
    db.driver=YOUR_DRIVER
    db.url=YOUR_URL
    db.user=YOUR_USERNAME
    db.password=YOUR_PASSWORD
```
5. Create the necessary name of DB
6. Run project

## 🚀 Example of parameters for db.properties
``` java
    db.driver=com.mysql.cj.jdbc.Driver
    db.url=jdbc:mysql://localhost:3306/NameOfDataBase?useUnicode=true&serverTimezone=UTC
    db.user=root
    db.password=admin
```
