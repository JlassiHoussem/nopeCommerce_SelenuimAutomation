# nopCommerce Selenium Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange)  
![Maven](https://img.shields.io/badge/Maven-Build-blue)  
![TestNG](https://img.shields.io/badge/TestNG-Framework-green)  
![Allure](https://img.shields.io/badge/Allure-Report-purple)  
![Jenkins](https://img.shields.io/badge/Jenkins-CI/CD-red)

Automated UI tests for the nopCommerce demo site using Selenium WebDriver with Java, TestNG, Maven, and Allure reporting — plus Jenkins integration for CI.

---

## 📑 Table of Contents
1. [Overview](#-overview)
2. [Technologies & Tools](#-technologies--tools)
3. [Project Structure](#-project-structure)
4. [Setup & Installation](#-setup--installation)
5. [Running Tests](#-running-tests)
6. [Test Reporting](#-test-reporting)
7. [Continuous Integration (Jenkins)](#-continuous-integration-jenkins)
8. [Screenshots & Logs](#-screenshots--logs)

---

## 🔎 Overview
This framework automates UI tests for the nopCommerce demo site, validating user flows such as registration, login, and product purchases using Selenium WebDriver, organized with TestNG and Maven.

---

## 🛠 Technologies & Tools
- **Language**: Java  
- **Build Tool**: Maven (`pom.xml`)  
- **Testing Framework**: TestNG (with suites like `testng.xml`, `regressionSuite.xml`, `testngParallelTesting.xml`)  
- **Reporting**: Allure (`.allure/`, `allure-results/`)  
- **Browser Drivers**: Managed in `drivers/`  
- **CI/CD**: Jenkins (`Jenkinsfile`)  
- **Artifacts**: Screenshots (`Screenshots/`), reports (`test-output/`), compiled artifacts (`target/`)

---

## 📂 Project Structure
```
nopeCommerce_SelenuimAutomation/
├── .allure/
├── allure-results/
├── drivers/
├── Screenshots/
├── src/
│   ├── main/java/…
│   └── test/java/…
├── test-output/
├── target/
├── pom.xml
├── testng.xml
├── regressionSuite.xml
├── testngParallelTesting.xml
├── Jenkinsfile
└── README.md
```

---

## ⚙️ Setup & Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/JlassiHoussem/nopeCommerce_SelenuimAutomation.git
   cd nopeCommerce_SelenuimAutomation
   ```
2. Build with Maven:
   ```bash
   mvn clean install
   ```

---

## ▶️ Running Tests
- Default TestNG suite:
   ```bash
   mvn test
   ```
- Regression suite:
   ```bash
   mvn test -DsuiteXmlFile=regressionSuite.xml
   ```
- Parallel execution:
   ```bash
   mvn test -DsuiteXmlFile=testngParallelTesting.xml
   ```

---

## 📊 Test Reporting
Generate and view Allure report:
```bash
mvn allure:serve
```
The report opens automatically in the browser.

---

## 🔄 Continuous Integration (Jenkins)
The project includes a `Jenkinsfile` for CI pipelines. Jenkins can:
- Checkout the repository  
- Build with Maven (`mvn test`)  
- Publish Allure reports  
- Archive artifacts (reports, screenshots)  

---

## 📸 Screenshots & Logs
- Failed tests capture screenshots in `Screenshots/`  
- Test outputs stored in `test-output/`  
- Allure results in `allure-results/`  
- Visual reports generated in `.allure/`  

---
