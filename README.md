# 📝 Attendance Management System - Java GUI (Swing + MySQL)

A desktop-based **Attendance Management System** built using **Java Swing** for GUI and **MySQL** as the backend. The application allows teachers to manage attendance records, search for absent students by roll number, and copy reports. The project includes a basic login/signup system for teachers and supports class-wise student data management.

---

## ✅ Features Implemented

- 🔍 **Search by Roll Number**  
  Enter a roll number to find and display the absent student's name and roll number.

- 🧾 **Display Absentees**  
  Results are shown on a new GUI page with formatted output.

- 📋 **Copy Report Button**  
  Click to copy the report (name + roll number) to clipboard for easy sharing.

- 🔙 **Back Navigation**  
  Navigate between the search screen and home/dashboard easily.

- 🎨 **Fixed Layout & Design**  
  All components are styled using `setBounds()` with custom background colors.

- 🖼️ **Custom Logo & Background Support**  
  Project supports personalized branding via logo and background image.

---

## 🛠️ Technologies Used

- **Java** – Swing (GUI)
- **MySQL** – JDBC connection for data storage
- **JDK 8+**
- **NetBeans / IntelliJ IDEA** – Recommended IDEs

---

## 📂 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/OmkarM9090/attendance-management-java.git
Set up MySQL Database

Create a database (e.g., attendance_db)

Create tables using schema given below or import attendance_db.sql (if provided)

Update DB credentials

In DatabaseConnection.java, set your MySQL username, password, and DB name

Run the Project

Open the project in your IDE and run Main.java

🗃️ Database Schema
The system uses separate tables for each class/division (like bea, fea, etc.) and a teacher table for login/signup.

📌 Table: bea (Student Table for BE A Division)
Column Name	Data Type	Description
name	VARCHAR(50)	Full name of the student
roll	INT	Roll number of the student
email	VARCHAR(50)	Email address
phone	BIGINT	Phone number (Primary Key)
gender	CHAR(50)	Gender
class	CHAR(50)	Class/Division (e.g., BE-A, FE-A)

💡 SQL Schema
sql
Copy
Edit
CREATE TABLE bea (
    name VARCHAR(50),
    roll INT,
    email VARCHAR(50),
    phone BIGINT PRIMARY KEY,
    gender CHAR(50),
    class CHAR(50)
);
📌 Table: teacher (Login System)
Column Name	Data Type	Description
username	VARCHAR(50)	Teacher's username
password	VARCHAR(50)	Account password
phoneno	BIGINT	Phone number (Primary Key)
emailid	VARCHAR(50)	Email address
gender	CHAR(50)	Gender

💡 SQL Schema
sql
Copy
Edit
CREATE TABLE teacher (
    username VARCHAR(50),
    password VARCHAR(50),
    phoneno BIGINT PRIMARY KEY,
    emailid VARCHAR(50),
    gender CHAR(50)
);

---
📷 Screenshots
🏠 Home / Search Page

📋 Result Page (Absent Student Details)

🧾 Copy Report Button

---

🔜 Upcoming Features (Planned)
📤 Export attendance report to Excel and PDF

📲 WhatsApp sharing integration for quick report sharing

📊 Dashboard with class-wise attendance analytics

🧠 AI-based trend insights (Smart Alerts)
---
👨‍💻 Author
Omkar Mahadik
🎓 Computer Engineering Student
🔗 LinkedIn

📜 License
This project is licensed under the MIT License.

Feel free to use, modify, and distribute with credit.
