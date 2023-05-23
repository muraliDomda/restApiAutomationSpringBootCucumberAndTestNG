# 🦾 RestApiAuto
# Automate Rest Apis using Springboot, Rest Assured and Cucumber

## 🔢 Requiring (one time) manual setup by user

1. [**JDK 11 + **](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) - as language of choice
   for writing this test framework.
2. [**Maven 3.8.6+**](https://maven.apache.org/) - for project dependency management and running tests in CI.


## ⚙ Tool Set

Key tools to be used in this core framework are:

- [x] **Java** (As the core programming language)
- [X] **SpringBoot** (Dependency Injection)
- [x] **Maven** (for automatic dependency management)
- [x] **TestNG** (for assertions)
- [x] **Cucumber** (for BDD and Reporting)
- [x] **RestAssured**  (library for Rest API automation)
- [x] **GitHub** (for version control)


## Inprogress: 
- [ ] **GitHubActions** (for CI/CD)
- [ ] **Docker** (for automating test framework's environment)
- [ ] **SonarQube/SonarLint** (for keeping your code clean and safe)


🚀 Executing Tests and Generating Reports
To execute the tests and generate reports using Maven, follow these steps:

-Open a command prompt or terminal.
-Navigate to the root directory of the project.
-Run the following command to clean the project and execute the tests:

-mvn clean test


-This command will compile the project, execute the tests, and generate the test reports.

-After the execution is complete, you can find the generated reports in the target/cucumber-html-reports directory.