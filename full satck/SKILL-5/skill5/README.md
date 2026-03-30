# Spring Core - Skill 5: Autowiring with @Autowired

## Aim
Demonstrate Spring Autowiring using the @Autowired annotation by injecting a Course object into a Student object using annotation-based configuration.

## Concepts Covered
- @Component annotation for bean registration
- @Autowired annotation for automatic dependency injection
- Component scanning with context:component-scan
- Annotation-based Spring configuration

## Technologies
Java 11+, Spring Framework 5.3.30, Maven

## Project Structure
```
src/main/java/com/klu/
├── Course.java    (@Component - injected bean)
├── Student.java   (@Component + @Autowired)
└── App.java       (Main entry point)
src/main/resources/
└── applicationContext.xml
pom.xml
```

## How to Run
1. Import as Maven project in Eclipse/STS/IntelliJ
2. Run `App.java` as Java Application

## Expected Output
```
Student ID : 10
Student Name : Divya
Gender : Female
Course : Course [id=301, course=Spring Core, dateOfCompletion=25-Jan-2026]
```

## Git Push Commands
```bash
git init
git add .
git commit -m "Spring Autowiring Demo using @Autowired"
git branch -M main
git remote add origin https://github.com/your-username/Spring-Autowiring-Demo.git
git push -u origin main
```
