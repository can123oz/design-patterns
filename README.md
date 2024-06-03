## Description

This application demonstrates the use of the Factory and Strategy design patterns to handle different payment types in a clean and maintainable way. The patterns provide flexibility and scalability, allowing easy addition of new payment methods in the future.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Maven](https://maven.apache.org/) installed
- [Docker](https://www.docker.com/) installed and running

## Installation

To install the project, follow these steps:

1. Clone the repository: `git clone https://github.com/can123oz/design-patterns.git`
2. Navigate to the project directory: `cd design-patterns`
3. Build the project with Maven (skipping tests): `mvn clean package -DskipTests`
4. Build the Docker image: `docker build -t your-image-name .`

## Usage

To run the project, follow these steps:

1. Run the Docker container: `docker run -p 8080:8080 your-image-name`
2. Open a web browser and navigate to: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## Contact

If you have any questions or suggestions, feel free to contact [your contact information].
