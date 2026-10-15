# Chat Application - Part 1

## Overview

A Java command-line application demonstrating user registration and login. Users can register with a name, username, password, and South African cell phone number, then log in during the current run.

## Features

- Register a user and validate their username, password, and cell phone number.
- Log in with the registered username and password and display a personalized status message.
- Reject login attempts until a user has registered.

### Registration rules

- **Username:** Must contain an underscore (`_`) and be no more than five characters long. Leading and trailing whitespace is trimmed.
- **Password:** Must contain at least eight characters, one uppercase letter, one digit, and one special character. Leading and trailing whitespace is trimmed.
- **Cell phone number:** Must use the `+27` country code followed by exactly nine digits (for example, `+27838968976`).

## Requirements

- Java 17 or later
- Maven 3.6 or later

## Build, test, and run

Run these commands from the project root:

```bash
mvn clean package
mvn test
java -jar target/chatting-app-1.0-SNAPSHOT.jar
```

The application presents a menu to register, log in, or quit. Follow the prompts to enter the requested details.

## Project layout

```text
src/
  Login.java       Registration validation and login logic
  Main.java        Command-line menu and user interaction
tests/
  java/
    LoginTest.java Unit tests for registration and login
```

This is a learning project: registered details are kept in memory and are not saved after the application exits.
