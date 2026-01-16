# Inventory Service

A Spring Boot microservice for managing product inventory in the Poise platform. Built with clean architecture and domain-driven design principles.

## Project Architecture

This project follows **Clean Architecture** (Hexagonal Architecture) with a multi-module Maven structure. The architecture ensures separation of concerns, testability, and maintainability.

### Module Structure

```
inventory-service/
├── src/main/java/com/poise/inventory_service/
│   ├── modules/
│   │   └── product/                    # Product bounded context
│   │       ├── application/            # Use cases & application logic
│   │       │   ├── dto/               # Data transfer objects
│   │       │   │   ├── CreateProductRequest.java
│   │       │   │   └── ProductResponse.java
│   │       │   └── usecases/          # Application use cases
│   │       │       └── CreateProductUseCase.java
│   │       ├── domain/                 # Business logic & entities
│   │       │   ├── Product.java       # Product aggregate root
│   │       │   └── ProductRepository.java  # Repository interface
│   │       ├── infrastructure/         # Technical implementations
│   │       │   └── persistence/
│   │       │       ├── JpaProductRepository.java
│   │       │       └── ProductRepositoryImpl.java
│   │       └── presentation/           # REST API layer
│   │           └── ProductController.java
│   │
│   └── shared/                         # Shared abstractions & utilities
│       ├── application/
│       │   └── UseCase.java           # Base use case interface
│       ├── domain/
│       │   ├── BaseEntity.java        # Base entity for all aggregates
│       │   └── DomainEvent.java       # Base domain event interface
│       └── infrastructure/
│           └── persistence/
│               └── BaseJpaRepository.java  # Base JPA repository
```

### Architecture Layers

#### 1. **Presentation Layer** (`presentation/`)
- REST API controllers
- HTTP request/response handling
- Input validation
- Example: `ProductController.java`

#### 2. **Application Layer** (`application/`)
- Use case implementations
- Data Transfer Objects (DTOs)
- Application service orchestration
- Example: `CreateProductUseCase.java`

#### 3. **Domain Layer** (`domain/`)
- Core business logic and rules
- Domain entities and value objects
- Repository interfaces (abstraction)
- Domain events
- Example: `Product.java`, `ProductRepository.java`

#### 4. **Infrastructure Layer** (`infrastructure/`)
- Data persistence implementations (JPA/Hibernate)
- Repository implementations
- Database access and mapping
- External service integrations
- Example: `ProductRepositoryImpl.java`, `JpaProductRepository.java`

#### 5. **Shared Layer** (`shared/`)
- Common abstractions used across modules
- Base classes and interfaces
- Cross-cutting utilities
- Example: `BaseEntity.java`, `UseCase.java`, `DomainEvent.java`

### Key Design Principles

- **Dependency Inversion**: Domain layer depends on abstractions, not concrete implementations
- **Separation of Concerns**: Each layer has a specific responsibility
- **Testability**: Business logic is isolated from framework dependencies
- **Domain-Driven Design**: Modules organized around bounded contexts (e.g., Product)
- **SOLID Principles**: Applied throughout the architecture

## Technology Stack

- **Java**: 17
- **Framework**: Spring Boot 4.0.1
- **Build Tool**: Maven
- **Data Access**: Spring Data JPA with Hibernate
- **Database**: (Configured in application.properties)

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build
```bash
./mvnw clean package
```

### Run
```bash
./mvnw spring-boot:run
```

## Project Structure Benefits

1. **Modularity**: Each bounded context (e.g., Product) is self-contained
2. **Scalability**: Easy to add new modules or features
3. **Testability**: Domain and application logic can be tested without framework dependencies
4. **Maintainability**: Clear structure makes the codebase easy to navigate
5. **Flexibility**: Infrastructure implementations can be swapped without affecting business logic
