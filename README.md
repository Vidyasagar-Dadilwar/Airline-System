# Airline Management System

A springboot application that helps the users to manage their flights schedules and tickets using APIs built with Spring Boot.

## Table of Contents

- [Features](#features)
- [Built with](#technologies-used)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)

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

### API Documentation:

[API Documentation](https://docs.google.com/document/d/1PTTDHp-4E3P8spFV0Nwj4x8ygRlSIEpo3sUuCuquk7c/edit?usp=sharing)
