# Flight Booking Automation Framework

## Project Overview

This project is a Selenium Automation Framework developed using Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM) design pattern.

The framework automates an end-to-end flight booking flow, including flight search, flight selection, purchase, and booking confirmation.

---

## Tech Stack

* **Java**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **Page Object Model (POM)**
* **Git & GitHub**

---

## Framework Architecture

The framework follows the Page Object Model (POM) design pattern to improve maintainability, readability, and reusability.

### Components

#### BaseTest

* Initializes WebDriver
* Loads configuration
* Handles setup and teardown

#### DriverFactory

* Creates browser instances
* Supports browser configuration

#### ConfigReader

* Reads values from `config.properties`

#### Page Classes

* HomePage
* FlightSelectionPage
* PurchasePage
* ConfirmationPage

#### Test Classes

* HomePageTest
* FlightSelectionTest
* PurchasePageTest
* ConfirmationPageTest
* EndToEndTest

---

## Project Structure

```text
FlightBookingAutomationFramework
│
├── src/test/java
│   ├── base
│   │   └── BaseTest
│   │
│   ├── pages
│   │   ├── HomePage
│   │   ├── FlightSelectionPage
│   │   ├── PurchasePage
│   │   └── ConfirmationPage
│   │
│   ├── tests
│   │   ├── HomePageTest
│   │   ├── FlightSelectionTest
│   │   ├── PurchasePageTest
│   │   ├── ConfirmationPageTest
│   │   └── EndToEndTest
│   │
│   └── utils
│       ├── DriverFactory
│       └── ConfigReader
│
├── src/test/resources
│   └── config.properties
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## Features

* **Page Object Model (POM)**
* Reusable page methods
* Configuration management using properties file
* TestNG test execution
* Maven dependency management
* End-to-End flight booking validation
* Cross-browser support ready

---

## Design Patterns Used

* **Page Object Model (POM)**
* **Factory Design Pattern (DriverFactory)**

---

## Prerequisites

* **Java 17+**
* **Maven 3.9+**
* **Eclipse IDE**
* **Chrome Browser**

---

## Test Scenarios Covered

### Home Page

* Verify page loads successfully
* Verify flight search functionality

### Flight Selection Page

* Verify available flights are displayed
* Verify flight selection process

### Purchase Page

* Verify passenger details submission
* Verify booking process

### Confirmation Page

* Verify booking confirmation message
* Verify booking ID generation

### End-to-End Flow

* Search Flight
* Select Flight
* Enter Passenger Details
* Complete Booking
* Verify Confirmation

---

## How to Run Tests

### Clone Repository

```bash
git clone https://github.com/vaibhav-nagre9/FlightBookingAutomationFramework.git
```

### Navigate to Project

```bash
cd FlightBookingAutomationFramework
```

### Run All Tests

```bash
mvn test
```

### Run TestNG Suite

Run the suite from Eclipse:

1. Right-click `testng.xml`
2. Select **Run As → TestNG Suite**

Or execute using Maven:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## Future Enhancements

* Extent Reports Integration
* Screenshot Capture on Failure
* Parallel Execution
* Jenkins CI/CD Integration
* Cross Browser Execution
* Data Driven Testing using Excel

---

## Author

**Vaibhav Nagre**

Automation Testing | Selenium | Java | TestNG | Maven | Git
