
# Flight Booking Application (Angular + Spring Boot Microservices)

## Project Overview
This project is a **Flight Booking Application** built using **Angular (Frontend)** and **Spring Boot Microservices (Backend)**.  
It allows users to:
- Register and Login
- Search available flights
- search flight details in a modern UI

The application follows **microservices architecture** with **API Gateway** **Flight service** and **Eureka Service Discovery**.

---

## Architecture
- **Frontend**: Angular (HTML + CSS)
- **Backend**:
  - Auth Service
  - Flight Service
  - API Gateway
  - Eureka Server
- **Database**: MySQL
- **Security**: JWT
- **Communication**: REST APIs

---

## Frontend Features
- Clean & modern UI
- Background image with centered search card
- Flight search form (From, To, Date)
- Dynamic flight result cards
- Responsive design
- Connected to backend APIs

---

##  Backend Features
- User Registration & Login
- Flight Search API
- Microservices with Eureka Discovery
- API Gateway routing
- JWT-based security

---

##  Project Structure

### Frontend (Angular with spec.ts files)
```
src/
 ├── app/
 │   ├── login/
 │   ├── register/
 │   ├── search-flights/
 │   ├── services/
 │   ├── app.routes.ts
 │   └── app.component.ts
 |   └── auth-guard.ts
 |   └── jwt-interceptor.ts
 |   └── shared.css
 ├── styles.css
 └── main.ts
 

 
```

### Backend (Spring Boot)
```
auth-service/
flight-service/
api-gateway/
eureka-server/
```

---

##  How to Run the Project

### 1️ Backend Setup
1. Start **Eureka Server**
2. Start **Auth Service**
3. Start **Flight Service**
4. Start **API Gateway**

Ensure MySQL is running and database configuration is correct.

---

### 2️ Frontend Setup
```bash
npm install
ng serve
```

Access the application at:
```
http://localhost:4200
```

---

## 🔗 API Endpoints(gateway:localhost:8080)

### Auth APIs
- `POST /api/auth/register`
- `POST /api/auth/login`

### Flight APIs
- `GET /api/flights/search?from=DELHI&to=MUMBAI&date=2025-12-10`

---

##  UI Preview
- Flight search page with background image
- search card
- Flight result cards with price display

---

##  Tools & Technologies
- Angular
- Spring Boot
- Spring Cloud Gateway
- Eureka
- MySQL
- REST APIs
- HTML, CSS

---

## 👩‍💻 Author
**Manasa Mundru**

---

## 📄 License
This project is for educational purposes.
