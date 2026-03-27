# 📚 Library Management System

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white"/>
  <img src="https://img.shields.io/badge/JDBC-Database%20Connectivity-blue?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Project-Console%20Application-green?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge"/>
</p>

---

## 📌 Project Overview

A **console-based Library Management System** built using **Java (JDBC)** and **MySQL**.
This project allows users to perform core library operations like adding, viewing, updating, and deleting records using a simple menu-driven interface.

Developed as part of the **Anudip Foundation Training Program**, focusing on real-world backend development and database integration.

---

## 🚀 Features

* ➕ Add new book records
* 📖 View all books
* ✏️ Update book details
* ❌ Delete book records
* 📋 Menu-driven user interface
* 🔄 Real-time database interaction

---

## 🛠️ Tech Stack

| Technology | Description               |
| ---------- | ------------------------- |
| Java       | Core programming language |
| JDBC       | Database connectivity     |
| MySQL      | Relational database       |
| VS Code    | Development environment   |

---

## 🗄️ Database Schema

```sql
CREATE DATABASE sjbc;

USE sjbc;

CREATE TABLE Library (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    Sname VARCHAR(50),
    Bname VARCHAR(50),
    Bquantity INT,
    Ssection VARCHAR(20)
);
```

---

## 📁 Project Structure

```
LibraryManagementSystem/
 ├── lib/
 │    └── mysql-connector-j-9.6.0.jar
 ├── JDBC/
 │    └── LibraryDBCrudOperations.java
 └── README.md
```

---

## ⚙️ Setup Instructions

1. Install Java (JDK 8+)
2. Install MySQL and create database
3. Download MySQL Connector/J and place it in `lib/`
4. Configure classpath in VS Code

---

## ▶️ How to Run

### 🔹 Compile

```
javac -cp "lib/mysql-connector-j-9.6.0.jar" JDBC/LibraryDBCrudOperations.java
```

### 🔹 Run

```
java -cp "lib/mysql-connector-j-9.6.0.jar;." JDBC.LibraryDBCrudOperations
```

---

## 📸 Sample Output

```
===== MENU =====
1. Add book
2. View books
3. Update book
4. Delete book
5. Exit
```

---

## 🎯 Learning Outcomes

* Understanding of JDBC architecture
* Implementation of CRUD operations
* Hands-on experience with MySQL
* Handling user input in Java
* Building real-world backend logic

---

## 🏫 Organization

Developed under **Anudip Foundation** as part of skill development training.

---

## 👨‍💻 Author

**Mayur Choudhari**

---

## 🔮 Future Enhancements

* 🔐 User authentication system
* 📅 Issue & return book tracking
* 💰 Fine calculation system
* 🖥️ GUI version using Swing
* 🌐 Web-based version (Spring Boot)

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
