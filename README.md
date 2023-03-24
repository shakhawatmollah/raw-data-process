# raw-data-process
JDBC project for raw data process

# Features!
  - JDBC Project
  - Programming Language Java 8 and Database MySQL 8
  - Does not use any third-party library
  - Batch/Chunk export data from Database
  - Duplicate and Phone Number, Email validation applied
  - Java Thread applied

## System Requirements
- Java 8 or higher
- MySQL 8.0+

## How to use

MySQL Database Configuration
```properties
private static final String DB_USER = <DB_USERNAME>;
private static final String DB_PASSWORD = <DB_PASSWORD>;
```

Run the application
```sh
> DataProcessMain.java main class for read text file and process customers data
> DataExportMain.java main class for export valid, invalid customers as CSV format
```
