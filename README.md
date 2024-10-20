# Rule Engine with Abstract Syntax Tree (AST)

The Rule Engine with AST (Abstract Syntax Tree) project is a 3-tier rule engine application that determines user eligibility based on dynamic conditions. These rules are represented using ASTs, which allow easy parsing, modification, and combination of rules. The application allows users to dynamically create, combine, and evaluate rules using attributes such as age, department, salary, and experience.
# path for code: Rule_Engine_With_AST/src/SourceCode
# path for unit tests: Rule_Engine_With_AST/src/test

# Design Overview
The design of the rule engine revolves around using an Abstract Syntax Tree (AST) to represent logical conditions as rules. This approach allows flexible and dynamic rule evaluation, modification, and combination. Key design choices are:

AST for Rule Representation: Rules are broken down into nodes (operators or operands), which makes it easy to create complex logical expressions.
Dynamic Rule Modification: Rules can be dynamically created, modified, and combined using the AST structure.
Separation of Concerns: The application follows a 3-tier architecture, with the front-end handling the user interface, the middle tier managing rule logic, and the backend handling data storage using a relational database.

# Dependencies
Before building the application, ensure you have the following dependencies installed:

Java: Version 11 or higher
Maven: Version 3.6 or higher (for building the project)
OracleSQL: Version 11g or higher 

# Features
Create Rule: Users can create a rule from a string and store it as an AST in the database.
Combine Rules: Users can combine multiple rules into a single rule tree.
Evaluate Rule: The system evaluates rules dynamically based on user attributes.
JSON-Based Evaluation: JSON input is used to evaluate user attributes against rules.
Database-Backed: Oracle 21c Express Edition is used to store and retrieve rules.

# Architecture
The system follows a 3-tier architecture:

Frontend: Simple UI that takes rule input from the user.
API Layer: Middle tier responsible for creating, combining, and evaluating rules.
Backend: Database layer using Oracle Express Edition to store rules.
Abstract Syntax Tree (AST) Design:

Each rule is represented by an AST.
Nodes in the AST are of two types:
Operator Node: Represents logical operators like AND/OR.
Operand Node: Represents conditions (e.g., age > 30).

# Dependencies
1. Java 8+

The project is built using Java, so you need to install the Java Development Kit (JDK).
Ensure you have at least JDK 8 or above installed.

2. Oracle 21c Express Edition

Oracle database for storing the rules and application metadata.
Can be set up in a Docker container.
3. Maven

The project uses Maven for dependency management and build automation. Ensure Maven is installed.

4. JUnit 5 (Testing)

For unit testing and test case automation, we use JUnit 5.
JAR Dependencies:
junit-jupiter-api
junit-jupiter-engine
5. Mockito (Testing)

For mocking dependencies in unit tests.
JAR Dependencies:
mockito-core
6. Oracle JDBC Driver

To connect Java with the Oracle database, download the Oracle JDBC driver.

# Build and Setup Instructions

1. Set Up the Oracle Database
Run the Oracle 21c Express Edition Docker container as mentioned in the dependencies section.
Once the Oracle database is running, create the necessary tables in the database for storing rules.
CREATE TABLE RULES (
    RULE_ID NUMBER PRIMARY KEY,
    RULE_NAME VARCHAR2(255),
    RULE_STRING VARCHAR2(4000)
);
2. Configure Database Connection
Update your RuleDatabase class to include the correct Oracle JDBC connection settings:

java

String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
String username = "your-username";
String password = "your-password";
3. Testing
JUnit 5 tests are provided to ensure that rules are created, combined, and evaluated correctly. 

4. Test Coverage
Create Rule: Ensures that the AST is correctly created from a rule string.
Combine Rules: Validates that multiple rules are combined efficiently into a single AST.
Evaluate Rule: Tests if the rule evaluation works correctly with JSON data inputs.


# Troubleshooting
Common Issues
Database Connection Error: Ensure Oracle is running and the JDBC URL is correct.
NullPointerException during AST Evaluation: Make sure all nodes are properly initialized before rule evaluation.
Tests Not Running: Check that JUnit 5 is properly set up in the pom.xml.


