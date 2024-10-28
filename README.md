# Task for DEXENTRI - Seller SKU Management API

## Overview
This project is a backend API for managing Seller-Specific SKUs (Stock Keeping Units) based on a shared product catalog. The API allows sellers to add their own SKUs, associate them with their profiles, and manage these SKUs using MongoDB as the database.

### Technology Stack
- **Java 17**
- **Spring Boot**
- **Spring Data MongoDB**
- **MongoDB**

## Features
- **Add Seller-Specific SKUs**: Create SKUs that are specific to a seller, based on a shared product catalog.
- **CRUD Operations**:
    - **Create**: Add new Seller SKUs.
    - **Read**: Retrieve all SKUs or a specific SKU by ID.
    - **Delete**: Remove an SKU by ID.
- **Profile and Product Management**: Each SKU can be associated with one or more seller profiles and reference a product from the shared catalog.

## Getting Started

### Prerequisites
- **Java 17**
- **MongoDB** (Ensure MongoDB is running locally or remotely)
- **Maven** (for building and running the project)

### Running MongoDB
1. Ensure MongoDB is running locally on your machine. If MongoDB is not installed, you can follow the [official MongoDB installation guide](https://docs.mongodb.com/manual/installation/).

### Application Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/filipdbr/user_account
   ```

2. Navigate to the project directory:
   ```bash
   cd user_account
   ```

3. Configure your MongoDB connection in `application.yml`:
   ```bash
   spring:
    data:
    mongodb:
    uri: mongodb://localhost:27017/user_account_db
   ```

4. Build and run the project:
   ```bash
   mvn spring-boot:run
   ```

5. The application will start running at:
   ```bash
   http://localhost:8080
   ```
   
## API Endpoints

### 1. Add a New Seller SKU
- **Endpoint**: `POST /api/seller_skus/add`
- **Description**: Add a new seller-specific SKU to the system.
- **Request Body**:
  ```json
  {
    "name": "Example Product",
    "description": "Product description here",
    "imageUrls": ["https://example.com/image1.jpg", "https://example.com/image2.jpg"],
    "product": {
      "id": "product123",
      "name": "Example Shared Product",
      "description": "Shared product description"
    },
    "profiles": [
      {
        "id": "profile123",
        "companyName": "Example Seller",
        "description": "Seller profile description"
      }
    ]
  }

### 2. Get All Seller SKUs
- **Endpoint**: `GET /api/seller_skus/all`
- **Description**: Retrieve all seller SKUs.

### 3. Get Seller SKU by ID
- **Endpoint**: `GET /api/seller_skus/{id}`
- **Description**: Retrieve a seller SKU by its ID.

### 4. Delete a Seller SKU by ID
- **Endpoint**: `DELETE /api/seller_skus/{id}`
- **Description**: Delete a seller SKU by its ID.

## Running Tests
You can run the unit tests with Maven:
```bash
mvn test
```

## Future Enhancements
1. **DTO Integration**: Introduce Data Transfer Objects (DTOs) for more control over input and output.
2. **Dockerization**: Create a Dockerfile to containerize the application and MongoDB for easier deployment.
