# Student Management REST API

A simple REST API built with Spring Boot to perform CRUD operations for managing student records. This project was created to practice and demonstrate backend development skills.

## Technologies Used
* Java 21
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* ModelMapper

## How to Run
1.  **Clone the repository:**
    ```bash
    git clone [your-repo-link]
    ```
2.  **Configure the database:**
    Open `src/main/resources/application.properties` and update the database URL, username, and password for your local PostgreSQL instance.
3.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```
The API will be available at `http://localhost:8080`.

## API Endpoints

Here are the available endpoints:

| Method | Endpoint          | Description                        |
|--------|-------------------|------------------------------------|
| `GET`  | `/students`       | Get all students.                  |
| `GET`  | `/students/{id}`  | Get a single student by their ID.  |
| `POST` | `/students`       | Create a new student.              |
| `PUT`  | `/students/{id}`  | Update an existing student.        |
| `PATCH`| `/students/{id}`  | Partially update a student.        |
| `DELETE`| `/students/{id}` | Delete a student by their ID.      |
