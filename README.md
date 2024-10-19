# Rule-Engine-with-AST
Overview
The Rule Engine AST (Abstract Syntax Tree) project is designed to provide a robust and extensible framework for creating and managing rules within applications. This engine parses rules written in a specific syntax and compiles them into an AST for further evaluation and execution. This README provides comprehensive details about building, setting up, and running the application.


Abstract Syntax Tree Representation: The engine converts rules into an AST for efficient evaluation.
Modular Architecture: The project is designed for easy extensibility and maintainability.
# Dependencies
Before building the application, ensure you have the following dependencies installed:

Java: Version 11 or higher
Maven: Version 3.6 or higher (for building the project)
OracleSQL: Version 11g or higher 


# Design Choices
Language: The project is implemented in Java for its robust type system and cross-platform capabilities.
Architecture: The application follows a modular architecture pattern, separating concerns to improve maintainability and extensibility.
AST Representation: The Abstract Syntax Tree design allows for efficient rule evaluation and easy manipulation of rule structures.
Running the Application
To run the application, follow these steps:

Ensure the OracleDB is running (as described in the Dependencies section).

Start the application with the following command:

bash
Copy code
java -jar target/rule-engine-ast.jar
The application will be accessible at http://localhost:1521.

# Usage
Once the application is running, you can:

Define rules using the provided syntax.
Submit rules for evaluation via the API endpoints.
Retrieve results from the evaluated rules.
Refer to the API documentation for detailed usage instructions.


