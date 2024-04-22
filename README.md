# Project "Task Manager"

This project is a web application for task management developed using Java, Spring Boot, Hibernate, MySQL, and Docker.

## Features

- **CRUD Operations**: The application allows creating, reading, updating, and deleting tasks.
- **Task Status**: Each task has a status (IN_PROGRESS, DONE, PAUSED) that can be updated.
- **Docker**: The project includes a Dockerfile and docker-compose.yml for easy deployment.

## How to Run

1. Clone the repository.
2. Install Docker and Docker Compose if not already installed.
3. Run `docker-compose up` in the project's root directory.
4. Open a web browser and go to `http://localhost:8080/root`.

## Interesting Approaches

- **Docker**: Using Docker makes it easy to deploy the application on any server.
- **Hibernate**: Using Hibernate simplifies interaction with the database.
- **Thymeleaf**: Thymeleaf is used for server-side web page generation.
- **AJAX**: AJAX is used to perform CRUD operations without page reloading.
