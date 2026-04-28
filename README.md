<h1 align="center">🚀 Nexus CRM - Backend API</h1>

<p align="center">
  <i>A high-performance, robust RESTful API built to power the Nexus CRM system. Designed with a focus on security, scalability, and seamless deployment.</i>
</p>

---

## 🛠️ Tech Stack

* **Language:** Java 21
* **Framework:** Spring Boot 3
* **Security:** Spring Security & JWT (Stateless Authentication)
* **Database:** PostgreSQL (Neon Serverless Cloud) & Spring Data JPA
* **API Documentation:** Swagger UI / OpenAPI 3.0
* **Containerization:** Docker
* **Deployment:** Render

## ✨ Key Features

* **N-Tier Architecture:** Clean separation of concerns using Controller, Service, and Repository layers.
* **Role-Based Access Control (RBAC):** Secure endpoints with custom JWT authentication filters.
* **Interactive API Docs:** Fully integrated Swagger/OpenAPI for real-time endpoint testing and documentation.
* **Centralized Error Handling:** Implemented a `GlobalExceptionHandler` for consistent, user-friendly API responses.
* **Optimized CORS Configuration:** Built a high-precedence custom CORS filter for seamless frontend-backend communication.
* **Stateless & Containerized:** Fully stateless session management deployed via optimized multi-stage Docker builds.

## ⚙️ Local Setup Instructions

**1. Clone the repository:**
```bash
git clone https://github.com/harshu06969o/nexus-crm-backend.git
cd nexus-crm-backend
```

**2. Database Configuration:**
Create an `application.properties` file in the `src/main/resources` directory with your local or cloud PostgreSQL credentials:
```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/your_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=your_password
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```

**3. Run the Application (Maven):**
```bash
./mvnw clean spring-boot:run
```
> The server will start on `http://localhost:8080`

**4. Run using Docker:**
If you prefer running the application in a containerized environment:
```bash
docker build -t nexus-backend .
docker run -p 8080:8080 nexus-backend
```
