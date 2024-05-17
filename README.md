# Project "Task Manager"

## Overview
This project is a web application for task management developed using Java, Spring Boot, Hibernate, MySQL, and Docker. It offers a robust and efficient solution for managing tasks, showcasing full CRUD (Create, Read, Update, Delete) functionality implemented through JavaScript.

## Features

- **CRUD Operations**: Comprehensive CRUD operations are implemented for task management using JavaScript, allowing for seamless interaction and dynamic updates.
- **Task Status Management**: Each task can have a status (IN_PROGRESS, DONE, PAUSED) that can be updated easily, enhancing task tracking and management.
- **Docker Integration**: The project includes a Dockerfile and docker-compose.yml, ensuring easy deployment and scalability.
- **Responsive Design**: Ensures optimal user experience across different devices with a responsive interface.
- **Backend Integration**: The backend is powered by Java and Spring Boot, with Hibernate managing database interactions, providing a robust and scalable architecture.

## How to Run

1. **Clone the Repository**: Start by cloning the repository to your local machine.
2. **Install Docker**: Ensure Docker and Docker Compose are installed on your system.
3. **Build and Run Containers**: Navigate to the project’s root directory and run the following commands:
   - `docker-compose build`
   - `docker-compose up`
4. **Access the Application**: Open a web browser and navigate to `http://localhost:8080/root` to access the Task Manager application.

## Noteworthy Implementations

- **JavaScript for CRUD Operations**: JavaScript is utilized to handle CRUD operations dynamically, providing a seamless user experience without the need for page reloads.
- **Docker for Easy Deployment**: Utilizing Docker simplifies the deployment process, making the application portable and easy to run on any server environment.
- **Hibernate for Database Management**: Hibernate ORM is used to manage database interactions, simplifying the data handling process and ensuring efficient database operations.
- **Thymeleaf for Templating**: The server-side rendering of web pages is managed using Thymeleaf, offering a powerful and flexible templating engine.
- **AJAX for Dynamic Updates**: AJAX is employed to perform CRUD operations, allowing for asynchronous data updates and a smoother user experience.

## Conclusion

This Task Manager project not only demonstrates proficiency in Java and Spring Boot but also highlights advanced frontend development skills with JavaScript. The integration of Docker, Hibernate, and AJAX showcases a modern approach to web application development, making it a valuable addition to any developer's portfolio.
