# Automation Exercise - UI Test Automation Framework

![Java](https://img.shields.io/badge/Java-007396?logo=openjdk&logoColor=white)
![Selenium WebDriver](https://img.shields.io/badge/Selenium_WebDriver-43B02A?logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6600)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)
![Allure Reports](https://img.shields.io/badge/Allure_Reports-8A2BE2)

A Java-based UI test automation framework for the [Automation Exercise](https://www.automationexercise.com/) e-commerce website. The project uses **Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM)**, with JSON test data mapped to POJO classes and Allure for test execution reporting.

**Repository:** [automation-exercise-ui-automation](https://github.com/Hassnaa24/automation-exercise-ui-automation)

---

## Contents

- [Overview](#overview)
- [Technology Stack](#technology-stack)
- [Test Coverage](#test-coverage)
- [Framework Architecture](#framework-architecture)
- [Allure Reporting](#allure-reporting)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Skills Demonstrated](#skills-demonstrated)
- [Future Enhancements](#future-enhancements)
- [Author](#author)

---

## Overview

This project demonstrates the design and implementation of a maintainable UI test automation framework for validating key e-commerce user journeys.

The framework separates page interactions from test logic using the Page Object Model, keeps test data separate from test scenarios, and uses TestNG XML files to organize test execution. Allure reporting supports the review of test outcomes and investigation of failed or broken tests.

The project focuses on reusable components, structured test organization, and clear reporting to support maintainable automation.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Browser automation and UI interaction |
| TestNG | Test execution, grouping, and suite management |
| Maven | Build and dependency management |
| Page Object Model (POM) | Separation of page interactions from test logic |
| JSON and POJO classes | Structured test data and data mapping |
| Allure Reports | Test execution reporting and result analysis |
| IntelliJ IDEA | Development environment |
| Git and GitHub | Version control and project hosting |

## Test Coverage

The test scenarios are organized into packages based on website functionality.

| Feature Area | Test Package | Coverage |
|---|---|---|
| User registration | `Registration` | Account creation and registration with an already-registered email |
| Authentication | `Login` | Valid login and invalid credentials |
| Product search | `Search` | Searching for products |
| Product browsing | `View` | Viewing product details, categories, and brands |
| Cart management | `Add_Remove_Products` | Adding and removing products and reviewing cart contents |
| Product reviews | `Review` | Submitting product reviews |
| Page interactions | `Scroll` | Scrolling and recommended-product interactions |
| Subscription | `Subscription` | Subscription-related checks |

The repository also contains TestNG suite configuration files for organizing and executing the test scenarios.

## Framework Architecture

The framework separates test scenarios, page interactions, test data, and shared setup to improve readability and maintainability.

```mermaid
flowchart LR
    A["TestNG XML Suites"] --> B["Test Classes"]

    B --> C["Page Objects"]
    B --> D["JSON Test Data"]
    B --> F["Base Setup"]
    B --> H["Listeners and Allure Integration"]

    C --> G["Utilities and WebDriver"]
    F --> G

    D --> E["POJO Classes"]

    H --> I["Allure Results"]
    I --> J["Allure Report"]

    classDef test fill:#1f4e78,stroke:#5b9bd5,color:#ffffff
    classDef support fill:#244a3a,stroke:#70ad47,color:#ffffff
    classDef reporting fill:#7030a0,stroke:#b4a7d6,color:#ffffff

    class A,B test
    class C,D,E,F,G support
    class H,I,J reporting

### Main Components

| Component | Responsibility |
|---|---|
| Page Objects | Encapsulate web elements, locators, and page-level actions |
| Test Classes | Define test scenarios and assertions |
| Base Setup | Provide shared test initialization and teardown |
| Utilities | Centralize reusable helper functions and WebDriver management |
| Listeners | Handle test execution events and support reporting integration |
| POJO Classes | Represent structured test data |
| JSON Test Data | Store test data separately from test logic |
| TestNG XML Files | Organize test suites and execution |

## Allure Reporting

Allure is integrated into the framework to provide a visual overview of test execution and help investigate test outcomes.

The report supports:

- **Execution overview:** A summary of test outcomes.
- **Suite-level reporting:** Results organized by TestNG suite.
- **Test-level details:** Individual test outcomes and diagnostic information.
- **Failure investigation:** Information to help analyze assertion failures and execution exceptions.
- **Visual reporting:** A structured interface for reviewing test results.

### Generate the Report

After executing the tests, the framework should generate result files in the configured Allure results directory.

If Allure CLI is installed and available in your system PATH, run:

```bash
allure serve allure-results
```

This command generates a report from the available results and opens it in your browser.

For accurate reporting, ensure that the tests have executed successfully at the framework level and that the Allure TestNG integration is configured correctly.

## Project Structure

```text
.
├── src
│   ├── main
│   │   └── java
│   │       ├── pages              # Page objects
│   │       ├── Pojo_classes       # Test data models
│   │       └── utilities          # Helpers and WebDriver management
│   └── test
│       ├── java
│       │   ├── Base               # Shared setup
│       │   ├── Listeners          # Execution listeners
│       │   └── Test_cases
│       │       ├── Add_Remove_Products
│       │       ├── Login
│       │       ├── Registration
│       │       ├── Review
│       │       ├── Search
│       │       ├── Scroll
│       │       ├── Subscription
│       │       └── View
│       └── resources
│           └── Test_Data          # JSON test data
├── pom.xml
├── master.xml                     # Main TestNG suite
├── suite_*.xml                    # Individual suites
├── Test_groups.xml                # Group-based execution
└── README.md
```

## Getting Started

### Prerequisites

- Java JDK installed and configured.
- Maven installed and available in your terminal.
- IntelliJ IDEA or another Java IDE.
- A supported browser and compatible WebDriver configuration.
- Git installed.
- Allure CLI installed if you want to generate and view reports locally.

### Clone the Repository

```bash
git clone https://github.com/Hassnaa24/automation-exercise-ui-automation.git
cd automation-exercise-ui-automation
```

### Open the Project

1. Open the project in IntelliJ IDEA.
2. Allow Maven to import the project and resolve its dependencies.
3. Review the browser and WebDriver configuration.
4. Review the test data and TestNG XML suite files.
5. Confirm that the Allure integration is configured before generating reports.

### Run the Tests

From the project root directory, execute:

```bash
mvn clean test
```

To run a specific TestNG suite, open and execute the relevant XML suite from IntelliJ IDEA. Maven-based suite selection depends on the configuration in `pom.xml`.

## Skills Demonstrated

- Java-based UI test automation.
- Selenium WebDriver and browser interaction.
- Page Object Model design and implementation.
- TestNG test organization and suite configuration.
- Data-driven testing with JSON and POJO classes.
- Reusable page objects and utility methods.
- Maven build and dependency management.
- Allure reporting and test result analysis.
- Git and GitHub for version control and project documentation.

## Future Enhancements

Potential improvements to extend the framework include:

- **Cross-browser testing:** Expand execution across supported browsers.
- **Test stability:** Review synchronization and use explicit waits where appropriate.
- **Parallel execution:** Explore parallel test execution to reduce runtime.
- **CI/CD integration:** Configure GitHub Actions to execute tests automatically.
- **Enhanced reporting:** Add consistent Allure feature, story, and severity annotations to improve report navigation.
- **Failure diagnostics:** Improve failure analysis and capture useful diagnostic information when tests fail.

## Author

**Hassnaa Ibrahim**  
ISTQB Certified Tester Foundation Level (CTFL v4.0) | QA Automation Engineer

An engineer building practical experience in software testing, including manual testing, UI automation, API testing, mobile testing, and performance testing.

- **GitHub:** [Hassnaa24](https://github.com/Hassnaa24)
- **LinkedIn:** [Hassnaa Ibrahim](https://www.linkedin.com/in/hassnaa-ibrahim)

### Related Projects

- [API Testing - Automation Exercise](https://github.com/Hassnaa24/Automation-Exercise-API-testing)
- [Manual Testing - Automation Exercise](https://github.com/Hassnaa24/Automation-Exercise-Manual-Testing)

---

*This repository is part of my QA portfolio and demonstrates my practical application of UI test automation principles, framework organization, and test reporting.*
