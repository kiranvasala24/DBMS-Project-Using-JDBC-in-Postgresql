# DBMS-Project-Using-JDBC-in-Postgresql
# JDBC PostgreSQL Database Interaction

This Java program demonstrates JDBC (Java Database Connectivity) usage with PostgreSQL database for performing CRUD (Create, Read, Update, Delete) operations.

## Prerequisites
- JDK (Java Development Kit)
- PostgreSQL
- PostgreSQL JDBC driver

## Setup

1. **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/your-repository.git
    ```

2. **Database Configuration**
    - Make sure PostgreSQL is installed and running.
    - Create a database named `your_database`.
    - Modify the JDBC connection URL, username, and password in the code to match your PostgreSQL setup:
      ```java
      Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/your_database", "your_username", "your_password");
      ```

3. **Running the Code**
    - Compile the Java code.
    - Execute the compiled `.class` file.

## Code Overview

- `Main.java`: Contains the Java code that establishes a connection to the PostgreSQL database and performs various SQL operations.
- The code includes SQL queries to perform updates, inserts, and fetch data from the `Product`, `Depot`, and `Stock` tables.
- It uses JDBC's `Statement` and `ResultSet` to execute SQL queries and display the results.

## Queries Performed
1. Update product name in Product and Stock tables.
2. Update depot name in Depot and Stock tables.
3. Insert a new depot and product into the Depot and Stock tables.
4. Fetch and display updated content of the Depot, Stock, and Product tables.

## Usage
1. Modify the code according to your database schema.
2. Compile the code using `javac Main.java`.
3. Run the compiled code using `java Main`.

## Notes
- Always handle exceptions appropriately in your code.
- Ensure to adjust the table and column names according to your database schema.

Feel free to customize and extend the code as needed for your use case.
