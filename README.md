# GoRest REST Assured Automation Framework

## Overview
Enterprise-style API automation framework built using Java, REST Assured, TestNG, and Maven.
It validates End-to-End CRUD operations using the GoRest Public APIs with industry best practices.

## Tech Stack
- Java, REST Assured, TestNG, Maven
- Bearer Token Authentication
- Data-Driven Testing (Excel – Apache POI)
- Extent Reports, Log4j2

## Key Coverage
- User CRUD API validation (POST, GET, PUT, DELETE)
- Backend verification including 404 validation
- Excel-driven test execution

## Framework Highlights
- Clean layered architecture (endpoints, payloads, utilities)
- Centralized configuration and token management
- CI/CD-ready with Maven & TestNG
- Reusable and scalable design

## Execution
```bash
mvn clean test
