# Student Management System

A console-based Student Management System developed using Java. This project demonstrates core Java programming, object-oriented programming (OOP), data structures, searching, sorting, and file handling.

## Features

- **Add Students** — Add student records with ID, name, course, and marks.
- **Display Students** — View all registered students.
- **Search Students** — Find a student using their ID.
- **Duplicate ID Prevention** — Prevent multiple students from having the same ID.
- **Update Students** — Modify student details and display the updated record.
- **Delete Students** — Remove a student using their ID.
- **Sort by Marks** — Sort students by marks in descending order using Bubble Sort.
- **Calculate Average Marks** — Calculate the average marks of all students.
- **File Persistence** — Save student records in `students.txt` and load them when the application restarts.
- **Input Validation** — Validate selected inputs to reduce invalid data entry.

## Technologies Used

- Java
- Apache Maven
- Git and GitHub
- Visual Studio Code

## Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Classes, objects, constructors, and encapsulation
- Java Collections Framework (`ArrayList`)
- Linear Search
- Bubble Sort
- Exception handling
- File handling using Java NIO
- Build management with Maven

## Project Structure

```text
student-management-system/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java
│           ├── Student.java
│           ├── StudentService.java
│           └── StudentFileService.java
├── students.txt
├── pom.xml
└── README.md
```

**File descriptions:**

- `Main.java` — Runs the menu-driven console application.
- `Student.java` — Defines the student model and its properties.
- `StudentService.java` — Handles student operations, searching, sorting, and average calculation.
- `StudentFileService.java` — Saves student records to a file and loads them when the application starts.
- `students.txt` — Stores student records locally.
- `pom.xml` — Contains Maven project configuration.

## Prerequisites

Install the following before running the project:

- JDK 24
- Apache Maven
- Git (optional, for cloning the repository)

## Installation and Setup

### 1. Clone the repository

```bash
git clone https://github.com/ravinduvimukthi/student-management-system.git
```

### 2. Open the project directory

```bash
cd student-management-system
```

### 3. Build the project

```bash
mvn clean package
```

### 4. Run the application

```bash
java -cp target/classes Main
```

## Application Menu

```text
1. Add student
2. Display all students
3. Search student by ID
4. Update Student
5. Delete Student
6. Sort Students by Marks
7. Calculate Average Marks
0. Exit
```

## Data Persistence

Student records are stored in `students.txt`. When the application starts, it loads the saved records into the system.

Each student record contains four lines:

1. Student ID
2. Student name
3. Course
4. Marks

This allows student records to remain available after closing and reopening the application.

**Note:** Keep `students.txt` in the working directory when running the application. Back up this file if you need to preserve your data.

## Future Improvements

- Improve validation for every user input.
- Add a graphical user interface.
- Introduce database integration using MySQL.
- Add automated unit tests.
- Improve file-data error handling.

## Author

**Ravindu Vimukthi**

ICT Undergraduate | Aspiring Software Engineer

GitHub: [@ravinduvimukthi](https://github.com/ravinduvimukthi)

---

This project is developed for learning and practising Java programming and software development fundamentals.
