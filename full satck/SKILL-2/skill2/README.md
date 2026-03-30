# Hibernate CRUD - Skill 2: Retail Inventory System

## Overview
Implements full CRUD operations using Hibernate ORM for a retail inventory system.

## Scenario
A retail inventory system stores product details (productId, name, description, price, quantity). The admin can add, retrieve, update, and delete products.

## Technologies
- Java 11+, Hibernate 6.x, MySQL 8, Maven

## Setup
1. Create MySQL database: `CREATE DATABASE inventory_db;`
2. Update `hibernate.cfg.xml` with your DB password
3. Run `App.java` as Java Application
4. Verify: `SELECT * FROM products;`

## Project Structure
```
src/main/java/com/inventory/
├── entity/Product.java      (@Entity with JPA annotations)
├── util/HibernateUtil.java  (SessionFactory singleton)
├── dao/ProductDAO.java      (CRUD operations)
└── main/App.java            (Main runner)
src/main/resources/
└── hibernate.cfg.xml
pom.xml
```

## CRUD Operations
- saveProduct()   → INSERT
- getProduct()    → SELECT by ID
- updateProduct() → UPDATE price & quantity
- deleteProduct() → DELETE by ID

## Expected Output
```
Product saved: Laptop
Product saved: Mouse
Fetched: Product [id=1, name=Laptop, description=Gaming Laptop, price=75000.0, quantity=10]
Updated product id=1
Deleted product id=2
All CRUD operations completed.
```

## ID Generation Strategies (Task 7)
Change `@GeneratedValue(strategy = GenerationType.AUTO)` to:
- `GenerationType.IDENTITY` — uses AUTO_INCREMENT
- `GenerationType.SEQUENCE` — uses DB sequence

## Viva Notes
- ORM maps Java objects to DB tables, reducing SQL code
- `@Entity` marks class as JPA entity
- `get()` returns null if not found; `load()` throws exception
- Every entity needs `@Id` for unique identification
