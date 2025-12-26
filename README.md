# gorest-restassured-framework
🚀 GoRest REST Assured Automation Framework

This repository contains a real-world, enterprise-ready API automation framework built using Java, REST Assured, TestNG, and Maven, leveraging GoRest public APIs for end-to-end CRUD validation.
The framework is designed following industry best practices for scalability, reusability, and CI/CD readiness.

🧰 Tech Stack
Language: Java
API Testing: REST Assured
Test Framework: TestNG
Build Tool: Maven
Data-Driven Testing: Excel (Apache POI)
Authentication: Bearer Token
Reporting: Extent Reports
Logging: Log4j2
API Used: GoRest Public API

📁 Project Structure
gorest-restassured-framework
│
├── src/main/java
│   ├── com.gorest.api.endpoints     # API endpoint classes
│   ├── com.gorest.api.payload       # POJO & Payload builders
│   ├── com.gorest.api.utilities     # Utilities (Config, Token, Excel, Reports)
│   └── com.gorest.api.routes        # API routes
│
├── src/test/java
│   ├── com.gorest.api.tests         # Test classes
│   └── com.gorest.api.dataprovider  # Excel data providers
│
├── src/test/resources
│   ├── config.properties            # Environment configuration
│   ├── testng.xml                   # TestNG suite
│   └── UserData/users.xlsx          # Excel test data
│
├── pom.xml
└── README.md

🔐 Authentication
The framework uses Bearer Token authentication.
Token and base URL are managed via config.properties:
base.url=https://gorest.co.in/public/v2
gorest.token=Bearer YOUR_ACCESS_TOKEN

Token handling is centralized using a reusable TokenUtil class.

✅ Test Coverage
✔ User CRUD Flow
Create User (POST)
Get User (GET)
Update User (PUT)
Delete User (DELETE)
Verify Deleted User (404)

✔ Data-Driven Testing
Multiple user scenarios driven from Excel
Supports easy test expansion without code changes

▶️ How to Run Tests
Run via Maven (CLI)
mvn clean test
Run via TestNG
Right-click testng.xml
Select Run As → TestNG Suite

📊 Reports
Extent Reports are generated after execution
Logs capture:
Request details
Response status
Masked authentication token
Reports are CI/CD compatible

💡 Key Framework Highlights

✔ Clean separation of concerns
✔ Reusable endpoint layer
✔ Centralized configuration management
✔ Excel-driven data providers
✔ CI/CD ready (Maven + TestNG)
✔ Production-style logging & reporting

📌 Future Enhancements
GitHub Actions CI pipeline
Environment switching (QA / Stage / Prod)
Parallel execution
Schema validation
Retry & failure handling

👤 Author
Bhargavi
