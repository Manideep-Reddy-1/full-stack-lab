# Spring Core - Skill 4: Constructor & Setter Dependency Injection

## Overview
Demonstrates Spring Dependency Injection using both Constructor Injection and Setter Injection via XML configuration (applicationContext.xml).

## Concepts Covered
- Constructor Injection (studentId, name, year injected via constructor)
- Setter Injection (course, email, phoneNumber injected via setters)
- XML Bean Configuration with applicationContext.xml
- Spring ApplicationContext loading

## Technologies
Java 11+, Spring Framework 5.3.30, Maven

## Project Structure
```
src/main/java/com/klu/
├── Course.java     (Constructor Injection target)
├── Student.java    (Mixed: Constructor + Setter)
└── App.java        (Main entry point)
src/main/resources/
└── applicationContext.xml
pom.xml
```

## How to Run
1. Import as Maven project in Eclipse/STS/IntelliJ
2. Run `App.java` as Java Application

## Expected Output
```
Student ID   : 101
Student Name : ram
Academic Year: 2026
Email        : ram@klu.edu
Phone Number : 9876543210
Course       : Spring Framework (6 months)
```
