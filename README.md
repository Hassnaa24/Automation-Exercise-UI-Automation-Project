# Automation Exercise -- UI Test Automation

**Java \| Selenium WebDriver \| TestNG \| Maven \| Page Object Model
(POM) \| Allure Reports**

A UI test automation project focused on validating key user journeys and
website functionality on [Automation
Exercise](https://automationexercise.com/). It demonstrates a structured
approach to browser automation using Java, Selenium WebDriver, TestNG,
and the Page Object Model, with Maven for dependency management and
Allure for reporting.

**Repository:**
[Hassnaa24/automation-exercise-ui-automation](https://github.com/Hassnaa24/automation-exercise-ui-automation)\
**Author:** [Hassnaa24 (Hassnaa Khalifa)](https://github.com/Hassnaa24)

------------------------------------------------------------------------

## Project Overview

This project was developed to practice and demonstrate maintainable UI
test automation. It separates test scenarios from page interactions and
uses reusable components to support readability, maintainability, and
future extension.

The test structure covers common e-commerce workflows, including product
discovery and cart operations, user account flows, and other website
features represented in the repository.

## Objectives

-   Automate representative end-to-end user journeys through the web
    interface.
-   Apply the Page Object Model to separate page actions from test
    logic.
-   Use TestNG to organize and execute test cases and suites.
-   Manage dependencies and execution through Maven.
-   Use reusable setup, utilities, and listeners to support test
    execution.
-   Generate test execution reports with Allure.

## Technology Stack

  Tool / Technology         Purpose
  ------------------------- -------------------------------------------------------
  Java                      Programming language
  Selenium WebDriver        Browser interaction and UI automation
  TestNG                    Test organization, execution, and suite configuration
  Maven                     Build and dependency management
  Page Object Model (POM)   Separation of page actions and test logic
  Allure                    Test execution reporting
  JSON                      Test data storage
  IntelliJ IDEA             Development environment
  Git & GitHub              Version control and project hosting

## Automated Test Coverage

The repository's test organization includes scenarios in areas such as:

-   **Product and cart workflows:** adding and removing products,
    viewing products/cart, and searching.
-   **User account workflows:** login and registration.
-   **Product feedback:** reviewing products.
-   **Website interactions:** scrolling and subscription-related checks.

Test group and suite configuration files are also included. Refer to the
test classes and suite XML files for the exact scenarios and current
coverage.

## Framework Design

-   **Page classes:** encapsulate page elements and interactions.
-   **Test classes:** contain scenarios and assertions.
-   **Base setup:** provides shared test initialization and
    configuration.
-   **Utilities:** centralize reusable helper functionality.
-   **Listeners:** support test execution event handling.
-   **Test data:** keeps data separate from test logic.
-   **Suite configuration:** defines test groups and execution.

This separation helps reduce duplication and makes test maintenance more
manageable when the application UI or test coverage changes.

## Project Structure

``` text
.
├── src
│   ├── main
│   │   └── java
│   │       ├── pages
│   │       ├── Pojo_classes
│   │       └── utilities
│   └── test
│       ├── java
│       │   ├── Base
│       │   ├── Listeners
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
│           └── Test_Data
├── pom.xml
├── master.xml
├── suite_*.xml
├── Test_groups.xml
└── README.md
```

## Getting Started

### Prerequisites

-   Java JDK installed and configured.
-   IntelliJ IDEA or another Java IDE.
-   Maven available (or use the Maven wrapper if included).
-   A supported browser and compatible WebDriver setup, as required by
    the project configuration.
-   Git installed.

### Clone the Repository

``` bash
git clone https://github.com/Hassnaa24/automation-exercise-ui-automation.git
cd automation-exercise-ui-automation
```

### Open and Configure

1.  Open the project in IntelliJ IDEA.
2.  Allow Maven to import the project and resolve dependencies.
3.  Check the browser and WebDriver configuration used by the framework.
4.  Review the test data and suite XML files before execution.

### Run the Tests

Run the Maven test phase:

``` bash
mvn clean test
```

To run a specific TestNG suite, use the suite file configured for your
project. For example, if Maven Surefire is configured to accept a suite
file:

``` bash
mvn clean test -DsuiteXmlFile=master.xml
```

If your project uses a different TestNG suite configuration, run the
relevant XML suite from IntelliJ IDEA or follow the configuration in
`pom.xml`.

## Test Reports

Allure is included for test reporting. After execution, generate and
open the report using the Allure setup configured on your machine and in
the project.

For example, when Allure CLI is installed and the results directory has
been generated:

``` bash
allure serve allure-results
```

The actual results directory and reporting configuration depend on the
project's setup. If no results are produced, confirm that tests executed
and that the Allure listener/dependency is configured.

## Skills Demonstrated

-   Designing and organizing UI test scenarios.
-   Writing browser automation with Java and Selenium WebDriver.
-   Applying Page Object Model principles.
-   Structuring tests and suites with TestNG.
-   Managing dependencies and execution with Maven.
-   Separating test data from test logic.
-   Using reusable setup and helper components.
-   Working with listeners and Allure reporting.
-   Maintaining a project with Git and GitHub.

## About Me

I'm Hassnaa Ibrahim, an engineer transitioning into Software Testing and
QA Automation. I'm building practical experience in manual testing, UI
automation, API testing, mobile testing, and performance testing, and
I'm interested in opportunities where I can contribute to software
quality and continue developing as a QA Engineer.

-   **GitHub:** [Hassnaa24](https://github.com/Hassnaa24)
-   **LinkedIn:** [Hassnaa
    Ibrahim](http://www.linkedin.com/in/hassnaa-ibrahim)

------------------------------------------------------------------------

*This project is part of my QA Automation portfolio. The repository's
source code and suite files provide the definitive details of
implemented scenarios and execution configuration.*
