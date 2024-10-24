# Eco-Powered AI Microservice

## Overview
This microservice provides an eco-friendly and insightful message about the universe while storing the history of GET parameters in an H2 database.

## Technologies Used
- Java 17
- Spring Boot
- H2 Database
- Docker
- JUnit for testing

## API Endpoint
### GET /universe-meaning/{param}
Returns a message about the sustainability of AI.

#### Example
To get the meaning of the universe with the parameter "sustainability", make a GET request to:

GET http://localhost:8080/universe-meaning/sustainability

### Installation

Follow these steps to set up and run the Eco-Powered AI Microservice:

1. **Download the project:**   
2. Open your terminal or command prompt and run
   cd ai-message-parser
3. Build the Application: Use Maven to build the project and download the necessary dependencies:
    **mvn clean install**
4. Set Up the Database: The application uses H2 as the embedded database for development and testing. H2 is configured in the application.properties file located in the src/main/resources directory.
Open the application.properties file:
   properties
   Copy code
   spring.h2.console.enabled=true

   spring.datasource.url=jdbc:h2:mem:testdb

   spring.datasource.driverClassName=org.h2.Driver

   spring.datasource.username=sa

   spring.datasource.password=password

   spring.jpa.hibernate.ddl-auto=update

5. Start the Application: Use the following command to run the application:
   **mvn spring-boot:run**

6. Run Unit Tests: To ensure the reliability and correctness of the application, run the test cases implemented in the project.
   mvn test
7. Test the API: Once the server is running, you can test the API endpoints using tools like Postman or cURL.
   Using cURL: Open a new terminal and run:

bash

Copy code

curl -X GET http://localhost:8080/universe-meaning/sustainability
Using Postman:

Open Postman.

Set the request type to GET.

Enter the URL http://localhost:8080/universe-meaning/sustainability and click Send.
You should see a response similar to:

**AI can help promote sustainability by optimizing energy usage sustainability."**

8.Docker Containerization

You can package the Eco-Powered AI Microservice in a Docker container for easier deployment.
Prerequisites
Make sure you have Docker installed on your machine. You can download it from Docker's official website.

Build the Docker Image
To build the Docker image, run the following command in your terminal from the root of your project directory:

bash
Copy code
docker build -t eco-powered-ai-microservice .
Run the Docker Container
Once the image is built, you can run the container using the following command:

bash
Copy code
docker run -p 8080:8080 eco-powered-ai-microservice
Accessing the Application
You can now access the microservice at http://localhost:8080/universe-meaning/sustainability.




