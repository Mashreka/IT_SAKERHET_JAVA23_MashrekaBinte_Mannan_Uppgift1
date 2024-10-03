# Delivery Service Application

## Project Overview

This project is a Java-based client-server application designed for a delivery service. Users can register, view, and delete their accounts while ensuring data security and compliance with GDPR (General Data Protection Regulation). The application utilizes a MySQL database to store user information.

## Features

- **Create Account**: Users can register by providing essential information.
- **View Account**: Users can retrieve their account details using their username.
- **Delete Account**: Users can remove their accounts from the database.
- **GDPR Compliance**: Only necessary information is collected, and users can manage their data.

## Usage Instructions

1. **Server Setup**: Launch the server application to handle API requests.
2. **Client Application**: Use the console client to interact with the server for account management.
3. **Database Configuration**: Ensure your MySQL database is properly set up and configured in the `application.properties` file.

## Security Measures

- **Password Hashing**: User passwords are hashed using SHA-256 before being stored, enhancing security by preventing plaintext password storage.
- **Authentication**: Spring Security is employed to protect endpoints and restrict access to authorized users.
- **Rate Limiting**: The API has rate limiting in place to prevent abuse, allowing a limited number of requests per minute.

## Database Information

The application utilizes a MySQL database for user account storage. Make sure to configure the database connection in the `application.properties` file with the correct URL, username, and password.

## Getting Started

1. Clone the repository to your local machine.
2. Set up your MySQL database and update the connection settings in the application.
3. Run the server application.
4. Use the console client to create, view, or delete user accounts.

## Conclusion

This project demonstrates the implementation of a secure delivery service application with essential user account management features.
