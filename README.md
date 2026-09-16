# XYZ Restaurant — Table Booking Management System

A desktop application (Java Swing) for managing restaurant table bookings, built as a NetBeans project. It provides separate flows for **Customers** (register, log in, book a table) and an **Admin** (log in, manage tables, manage customers, manage bookings), backed by a **MySQL** database.

## Features

**Customer**
- Register a new account (name, NIC, phone, email, password)
- Log in with existing credentials
- Book a table by date/time and party size (uses a calendar date picker)

**Admin**
- Log in with admin credentials
- View, add, update, and delete restaurant tables (table ID, capacity, price)
- View and delete customer records
- View and delete bookings

## Tech Stack

| Component | Details |
|---|---|
| Language | Java (Swing / AWT for UI) |
| IDE / Build | NetBeans project (Ant build — `build.xml`) |
| UI Toolkit extras | [JCalendar 1.4](https://toedter.com/jcalendar/) (date picker), JGoodies Looks (look & feel) |
| Database | MySQL, accessed via `mysql-connector-j-8.4.0` (JDBC) |
| Testing | JUnit 4.6 (bundled jar) |


## Prerequisites

- **JDK 8+** (project targets a classic desktop Swing/AWT app)
- **NetBeans IDE** (recommended, since this is a NetBeans/Ant project with `.form` GUI files) — or Ant + a JDK if building from the command line
- **MySQL Server** running locally

## Database Setup

The app connects to a MySQL database named **`xyzrestaurant`** on `localhost:3306` with user **`root`** and password **`xyz1234`** (see `src/database/ConnectionProvider.java`). Update these credentials in that file if your environment differs.

Based on the SQL used throughout the UI classes, create the database and the following tables before running the app:

```sql
CREATE DATABASE IF NOT EXISTS xyzrestaurant;
USE xyzrestaurant;

-- Registered customers
CREATE TABLE cust (
    name     VARCHAR(100),
    nic      VARCHAR(20)  PRIMARY KEY,
    telno    VARCHAR(20),
    email    VARCHAR(100),
    password VARCHAR(100)
);

-- Restaurant tables available for booking
CREATE TABLE tab (
    tableid  VARCHAR(20) PRIMARY KEY,
    capacity INT,
    price    DOUBLE
);

-- Bookings made against a table
CREATE TABLE booking (
    bookingid INT PRIMARY KEY,
    date      DATE,
    starttime TIME,
    endtime   TIME,
    capacity  INT,
    tableid   VARCHAR(20)
);
```


## Running the Application

### Option 1 — Run the prebuilt jar
```bash
cd XYZRestaurant/dist
java -jar XYZRestaurant.jar
```


### Option 2 — Open in NetBeans
1. Open the `XYZRestaurant` folder as a project in NetBeans.
2. Let it resolve the libraries in `lib/`.
3. Set `XYZUserInterface.Introduction` as the main class if it isn't already (see `nbproject/project.properties`).
4. Run the project (Shift+F6 or the Run button).

### Option 3 — Build with Ant from the command line
```bash
cd XYZRestaurant
ant clean
ant jar
java -jar dist/XYZRestaurant.jar
```

## Default Admin Login

Hardcoded in `XYZClasses/Admin.java`:
- **Username:** `admin`
- **Password:** `xyz1234`


## Application Flow

1. **Introduction** screen — choose to continue as Customer or Admin.
2. **Customer** path — sign in (`CustomerSignIn`) or register (`CustomerLoginCreation`), then proceed to **Table Booking**.
3. **Admin** path — sign in (`AdminSignIn`) with the hardcoded credentials above, then reach the **Admin Management** dashboard with options to manage tables, customers, and bookings.

## Known Limitations

- Admin credentials and the database password are hardcoded in source (`Admin.java`, `ConnectionProvider.java`) — not suitable for production use as-is.
- Passwords (customer and admin) are stored/compared in plain text — no hashing.


## License / Third-Party Notices

- **JCalendar** — LGPL (see `jcalendar-license.txt`)
- **JGoodies Looks** — BSD-style license (see `jgoodies-looks-license.txt`)
- **MySQL Connector/J** — see `mysql-connector-j-8.4.0/LICENSE`


