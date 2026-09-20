# Chat Application - Part 1

## Overview
This is Part 1 of the Chat Application project, implementing the registration and login feature.

## Features
- User registration with username, password, and South African cell phone number validation
- Username validation: contains underscore, max 5 characters
- Password complexity validation: min 8 chars, capital letter, number, special character
- Cell phone validation: international code (+27) format
- Login functionality with success/failure messages

## Technologies Used
- Java 11
- JUnit 5 for unit testing
- Maven for build automation
- Git for version control

## How to Build and Run

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Git

### Build the Project
```bash
mvn clean compile
