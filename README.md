# Airline Management System

A springboot application that helps the users to manage their flights schedules and tickets using APIs built with Spring Boot.

## Table of Contents

- [Features](#features)
- [Built with](#technologies-used)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Screenshots](#screenshots)

## Features

- **Flight Management:** Create flights schedules and manage them
- **User Management:** Deals with user registration and management
- **Ticket Booking:** Looks after the ticket system management includes creating, deleting, etc. of the tickets

## Built with

- **Java 21**
- **Spring Boot 3.4.3**
- **Maven**

## Getting Started

### Installation

1. Clone the repository:

```bash
git clone https://github.com/Vidyasagar-Dadilwar/Airline-System.git
cd Airline-System
```

2. Build the project:

```bash
mvn clean install
```

## API Documentation

### Flight Service API

Base URL: `http://localhost:8081/flights`

| Endpoint | Method | Description                                  |
|----------|--------|----------------------------------------------|
| `/` | POST | Create a new flight                          |
| `/{id}` | GET | Retrieve flight by ID                        |
| `/{id}/schedules?dates=` | GET | Get schedules for a flight |
| `/schedules/{id}` | GET | Get flight schedule by Id                    |
| `/?sort=` | GET | List of all flights                          |


### User Service API

Base URL: `http://localhost:8080/users`

| Endpoint | Method | Description              |
|----------|--------|--------------------------|
| `/` | POST   | Create a new user        |
| `/` | GET    | Retrive list of all users |
| `/{id}` | GET    | Retrive user by ID       |

### Ticket Service API

Base URL: `http://localhost:8082/tickets`

| Endpoint | Method | Description             |
|----------|--------|-------------------------|
| `/` | POST | Creates a new ticket    |
| `/{id}` | GET | Get ticket by ID        |
| `/{id}` | DELETE | Delete the ticket by ID |


## Screenshots


### APIs

#### Flight Service Endpoints

##### Getting flights
![image](https://github.com/user-attachments/assets/4cf17db1-839a-4537-bcbf-3ad31af5e153)
![image](https://github.com/user-attachments/assets/2d710226-32b3-4e9c-af3b-90a96e316980)

##### Getting individual flight
![image](https://github.com/user-attachments/assets/19bea1bf-2df3-484a-9fa9-0f707fdab97e)

##### Getting flight schedules
![image](https://github.com/user-attachments/assets/ae1c9c25-83d9-4c7c-8036-8b1d80f16125)
![image](https://github.com/user-attachments/assets/0936d229-868b-4860-b5d0-28a3dffd7f15)
![image](https://github.com/user-attachments/assets/c17d8453-1f53-46ba-b951-c92fdd368fe5)


##### Creating a flight
![image](https://github.com/user-attachments/assets/e055dc52-d276-4dbc-ad87-8cbd8e083f20)



#### User Service Endpoints

##### Getting all users
![image](https://github.com/user-attachments/assets/7829c40c-f018-42b9-8058-ad95fb622c8b)

##### Getting a specific user
![image](https://github.com/user-attachments/assets/ba08b001-5cf7-40ef-ad6a-aa49cbc2cb04)

##### Creating a user
![image](https://github.com/user-attachments/assets/712b8429-71c5-4437-b69f-1e186348919f)


#### Ticket Service Endpoints

##### Booking a ticket
![image](https://github.com/user-attachments/assets/93d921e4-c964-4e39-9c71-d7e5ebb0ab17)


##### Getting a ticket
![image](https://github.com/user-attachments/assets/40234553-b666-4170-b23b-c53830eef85d)


##### Cancelling a ticket
![image](https://github.com/user-attachments/assets/1dcb3f66-01c4-4b72-8a7a-0d4dd633da61)
![image](https://github.com/user-attachments/assets/004e88ed-e5ab-42ca-bf17-4b967a8b32b1)



### Validation Examples
![image](https://github.com/user-attachments/assets/cd1f06c2-55d9-4d1e-aa49-3cef67f76d34)
![image](https://github.com/user-attachments/assets/bb8f9557-cdb5-4343-bd5f-3104d275a1fe)
