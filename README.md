Bajaj Finserv Health - Java Qualifier Submission
This project is a solution for the Bajaj Finserv Health Java Qualifier 1 assessment. It is a Spring Boot application that automates a two-step API process upon startup.

Author Details:

Name: Adamya Harit

Registration Number: 22BCE2903

Email: adamya.harit2022@vitstudent.ac.in

Task Overview
The application performs the following actions automatically when it runs:

Generates a Webhook: It sends a POST request with the author's details to an API endpoint to receive a unique webhook URL and a JWT access token.

Solves a SQL Problem: Based on the author's registration number (22BCE2903, which is odd), it prepares the SQL query required for Question 1.

Submits the Solution: It sends the final SQL query as a POST request to the received webhook URL, using the JWT token for authorization.

Technology Stack
Framework: Spring Boot 3.x

Language: Java 17

Build Tool: Maven

HTTP Client: Spring WebFlux WebClient

Database: H2 In-Memory Database

Persistence: Spring Data JDBC

Utilities: Lombok

How to Build and Run
Prerequisites
Java Development Kit (JDK) 17 or later.

Apache Maven (or you can use the included Maven Wrapper).

Build Instructions
The project includes the Maven Wrapper, which will automatically download the correct version of Maven. Open a terminal or command prompt in the root directory of the project and run the appropriate command for your operating system.

On Windows:

mvnw.cmd clean package

On macOS / Linux:

./mvnw clean package

(If you get a "permission denied" error, run chmod +x mvnw first.)

This command will compile the code, run tests, and create an executable JAR file in the target/ directory named submission-0.0.1-SNAPSHOT.jar.

Run Instructions
Once the project is successfully built, you can run the application with the following command:

java -jar target/submission-0.0.1-SNAPSHOT.jar

The application will start, and you can monitor the console logs to see the output from the API calls.

Submission Checklist
This project fulfills all the requirements specified in the assignment PDF.

[x] Spring Boot Application: The project is built using Spring Boot.

[x] WebClient Usage: WebClient is used for making asynchronous API calls.

[x] Automatic Flow: The entire logic is triggered on startup using a CommandLineRunner, with no controllers or manual endpoints required.

[x] JWT Authorization: The JWT accessToken from the first API response is correctly used in the Authorization header for the second API call.

[x] Public GitHub Repository: The complete source code is available in a public repository.

[x] Final JAR Output: The build process generates a final, executable JAR file.
