# My Maven Project

## Overview
This is a Maven-based project structured to separate main application code from test code, following standard conventions.

## Project Structure
```
my-maven-project
├── src
│   ├── main
│   │   ├── java                # Main Java source files
│   │   └── resources           # Resource files (e.g., configuration)
│   └── test
│       ├── java                # Test Java source files
│       └── resources           # Resource files for testing
├── pom.xml                     # Maven Project Object Model file
└── README.md                   # Project documentation
```

## Getting Started
To build the project, navigate to the project root directory and run:
```
mvn clean install
```

## Dependencies
Add any necessary dependencies in the `pom.xml` file.

## Running Tests
To run the tests, use the following command:
```
mvn test
```

## License
This project is licensed under the MIT License.