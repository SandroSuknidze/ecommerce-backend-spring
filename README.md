# E-commerce Backend with Spring Boot

This repository contains the backend implementation of an e-commerce platform built using **Java** and **Spring Boot**. It provides RESTful APIs for managing products, categories, users, orders, and more.

## Features
- **User Authentication & Authorization**: Secure login and registration using Spring Security with JWT.
- **Product Management**: CRUD operations for products, categories, and brands.
- **Cart and Wishlist**: Add, update, and manage items in the cart and wishlist.
- **Order Management**: Place, track, and manage orders.
- **Payment Integration**: Integration with payment gateways for secure transactions.
- **Microservices Architecture**: Scalable design to handle large-scale operations.

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Security (JWT)**
- **Hibernate / JPA**
- **MySQL**
- **Maven**
- **Docker**

## Getting Started
### Prerequisites
- Java 17 or higher  
- MySQL  
- Maven

### Installation
1. Clone the repository:  
   ```bash
   git clone https://github.com/SandroSuknidze/ecommerce-backend-spring.git
   cd ecommerce-backend-spring
2. Configure the database in
    ```bash
   application.properties
3. Run the application:
   ```bash
   mvn spring-boot:run
