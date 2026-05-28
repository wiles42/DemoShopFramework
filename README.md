
# 🧪 Selenium Test Automation Framework

This is a UI test automation framework built using **Java, Selenium WebDriver, TestNG, and Gradle**, designed using the **Page Object Model (POM)** pattern.

The framework supports **smoke and regression test suites**, cross-browser execution, and is CI/CD ready for Jenkins.

---

## ⚙️ Tech Stack

- Java 21+
- Selenium WebDriver
- TestNG
- Gradle
- WebDriverManager
- Page Object Model (POM)
- Jenkins (CI/CD ready)
- Chrome, Firefox, Edge support

---

## 📁 Project Structure

```

src
└── test
├── java
│   ├── base        # Base test setup/teardown
│   ├── factory     # WebDriver factory
│   ├── pages       # Page Object classes
│   ├── tests       # Test classes
│   └── utils       # Helper utilities
└── resources
└── suites     # TestNG XML suites (smoke, regression)

````

---

## 🚀 How to Run Tests

### ▶ Run all tests

```bash
./gradlew test
````

---

### 🔥 Run Smoke Suite

```bash
./gradlew test -DsuiteXmlFile=src/test/resources/suites/smoke.xml
```

---

### 🧪 Run Regression Suite

```bash
./gradlew test -DsuiteXmlFile=src/test/resources/suites/regression.xml
```

---

### 🖥 Run Headless (CI/CD)

```bash
./gradlew test -DsuiteXmlFile=src/test/resources/suites/regression.xml -Dheadless=true
```

---

### 🌐 Run on Specific Browser

```bash
./gradlew test -Dbrowser=chrome
./gradlew test -Dbrowser=firefox
./gradlew test -Dbrowser=edge
```

---

## 🧠 Key Features

* Page Object Model (POM) design for maintainability
* Centralized WebDriver management via DriverFactory
* Cross-browser test execution
* Smoke and Regression TestNG suites
* Headless execution support for CI/CD pipelines
* Dynamic test data generation (unique users per run)
* Explicit waits for stable automation execution

---

## ⚙️ CI/CD Ready (Jenkins)
* CI/CD pipelin implemented using Jenkins integrated with GitHub and Gradle for automated test execution.
```bash
./gradlew clean test -DsuiteXmlFile=src/test/resources/suites/regression.xml
```

---

## 🧪 Test Strategy

### Smoke Suite

* Critical user flows
* Fast execution
* Used for deployment confidence

### Regression Suite

* Full end-to-end coverage
* All major application flows
* Pre-release validation

---

## ⚠️ Notes

* Some UI elements require explicit waits due to dynamic loading
* Bugs were found in invalid cart quantity update and Address deletion. Address deletion was left out due to unreliable backend performance.
* Tests are designed to be independent and repeatable

---

## 📦 Future Improvements

* Add Allure / Extent reporting
* Parallel execution via TestNG
* Dockerized Selenium Grid support
* API + UI hybrid framework expansion

---

## 👤 Author

Wiley Griffin
QA Automation Engineer (Java + Selenium)

---

## 🚀 Summary

This framework demonstrates:

* Scalable automation architecture (POM)
* CI/CD readiness
* Cross-browser testing
* Real-world QA automation design patterns




