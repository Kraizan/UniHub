# UniHub

UniHub is a microservices-based application designed to manage users, products, transactions, and provide a gateway for routing requests. The project uses Spring Boot for building the microservices and Spring Cloud for service discovery and routing.

## Technological Stack

- **Java 23**
- **Spring Boot 3.3.4**
- **Spring Cloud 2023.0.3**
- **Eureka for Service Discovery**
- **Spring Cloud Gateway**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Zipkin for Distributed Tracing**

## Architecture

The project is divided into several microservices, each responsible for a specific domain:

- **gateway**: API Gateway for routing requests to the appropriate microservices.
- **service-reg**: Service Registry using Eureka for service discovery.
- **productms**: Product Microservice for managing products.
- **transactionms**: Transaction Microservice for managing transactions.
- **userms**: User Microservice for managing users.

## Features

- **User Management**: Create, update, delete, and retrieve user information.
- **Product Management**: Create, update, delete, and retrieve product information.
- **Transaction Management**: Create, update, delete, and retrieve transaction information.
- **Service Discovery**: Dynamic discovery of microservices using Eureka.
- **API Gateway**: Centralized routing of requests to the appropriate microservices.
- **Distributed Tracing**: Track and monitor requests across microservices using Zipkin.

## Microservices

### Gateway

The gateway service is responsible for routing incoming requests to the appropriate microservices.

- **Configuration**: [gateway/src/main/resources/application.properties](gateway/src/main/resources/application.properties)
- **Main Application**: [gateway/src/main/java/com/kraizan/gateway/GatewayApplication.java](gateway/src/main/java/com/kraizan/gateway/GatewayApplication.java)

### Service Registry

The service registry uses Eureka for service discovery.

- **Configuration**: [service-reg/src/main/resources/application.properties](service-reg/src/main/resources/application.properties)
- **Main Application**: [service-reg/src/main/java/com/kraizan/service_reg/ServiceRegApplication.java](service-reg/src/main/java/com/kraizan/service_reg/ServiceRegApplication.java)

### Product Microservice

The product microservice manages products.

- **Configuration**: [productms/src/main/resources/application.properties](productms/src/main/resources/application.properties)
- **Main Application**: [productms/src/main/java/com/kraizan/productms/ProductmsApplication.java](productms/src/main/java/com/kraizan/productms/ProductmsApplication.java)
- **Implementation**: [productms/src/main/java/com/kraizan/productms/product/impl/ProductServiceImpl.java](productms/src/main/java/com/kraizan/productms/product/impl/ProductServiceImpl.java)

### Transaction Microservice

The transaction microservice manages transactions.

- **Configuration**: [transactionms/src/main/resources/application.properties](transactionms/src/main/resources/application.properties)
- **Main Application**: [transactionms/src/main/java/com/kraizan/transactionms/TransactionmsApplication.java](transactionms/src/main/java/com/kraizan/transactionms/TransactionmsApplication.java)
- **Implementation**: [transactionms/src/main/java/com/kraizan/transactionms/transaction/impl/TransactionServiceImpl.java](transactionms/src/main/java/com/kraizan/transactionms/transaction/impl/TransactionServiceImpl.java)

### User Microservice

The user microservice manages users.

- **Configuration**: [userms/src/main/resources/application.properties](userms/src/main/resources/application.properties)
- **Main Application**: [userms/src/main/java/com/kraizan/userms/UsermsApplication.java](userms/src/main/java/com/kraizan/userms/UsermsApplication.java)
- **Implementation**: [userms/src/main/java/com/kraizan/userms/user/impl/UserServiceImpl.java](userms/src/main/java/com/kraizan/userms/user/impl/UserServiceImpl.java)

## Steps to Run the Project

To build and run the project, you need to have Maven and Docker installed.

1. **Build the project**:
    ```sh
    ./mvnw clean install
    ```

2. **Run the services**:
    ```sh
    docker-compose up
    ```
