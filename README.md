```md
# Employee Management Microservice

This is a simple Employee Management microservice built using **Spring Boot**, which manages employee records using a file-based database (`employees.json`). 

## Features
- Create Employee API (`POST /employees`) - Adds a new employee.
- Get Employee by ID (`GET /employees/{id}`) - Retrieves employee details by ID.
- Get Employees (`GET /employees`) - Fetches employees with optional filtering based on name and salary range.
- File-based storage for simplicity (`employees.json`).

## Tech Stack
- **Java 21**
- **Spring Boot**
- **Jackson (for JSON parsing)**

## API Endpoints

### 1. Create Employee
- **Endpoint:** `POST /employees`
- **Request Body:**
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "salary": 5000
  }
  ```
- **Response:** `201 Created`

---

### 2. Get Employee by ID
- **Endpoint:** `GET /employees/{id}`
- **Response Example:**
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "salary": 5000
  }
  ```

---

### 3. Get Employees (with optional filters)
- **Endpoint:** `GET /employees`
- **Query Parameters:**
  - `name` → Filters by first or last name (contains).
  - `fromSalary` → Filters employees with salary ≥ `fromSalary`.
  - `toSalary` → Filters employees with salary ≤ `toSalary`.

**Example Request:**
```
GET /employees?name=John&fromSalary=3000&toSalary=6000
```

---

## How to Run

1. Clone the repository:
   ```sh
   git clone https://github.com/MohammedAlasmawi/employee-management.git
   cd employee-management
   ```
2. Build the project:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```
4. The service will be available at `http://localhost:8080`.

---

## Future Improvements
- Implement an update API.
- Migrate to PostgreSQL for scalability.
- Improve file-based storage with better error handling.

---

## Author
**Mohamed Alasmawi**  
Cloud & Data Analytics | Software Development  
```
