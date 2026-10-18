# Chat Application

## Overview

This Java command-line application allows users to register, log in, and interact with a simple chat menu. It validates registration details and supports sending, storing, or disregarding messages while the app is running.

## Features

- Register a user with a first name, last name, username, password, and South African cell number.
- Validate username, password, and mobile number format.
- Log in only after a user has successfully registered.
- Open a QuickChat menu after successful login.
- Send messages to a recipient number, validate the recipient cell number, and choose whether to send, store, or ignore the message.
- Store message metadata in memory during the current run.
- Run automated tests for both registration/login and message behavior.

### Validation rules

- **Username:** Must contain an underscore (`_`) and be no more than five characters long.
- **Password:** Must be at least eight characters long, contain one uppercase letter, one number, and one special character.
- **Cell phone number:** Must use the `+27` country code followed by exactly nine digits, for example `+27838968976`.
- **Message recipient:** Must be a valid `+27` number in the expected format.
- **Message length:** Messages must be 250 characters or fewer.

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

The application presents a menu to register, log in, or exit. After login, the QuickChat menu offers options to send messages, view recent activity, or quit.

## Project layout

```text
src/
  Login.java       Registration and login validation logic
  Main.java        Console menu and chat flow
  Message.java     Message validation, hashing, storage, and tracking

tests/
  java/
    LoginTest.java Unit tests for login, registration, and message behavior
```

This is a learning project: user and message data are kept in memory only and are not saved after the application exits.
