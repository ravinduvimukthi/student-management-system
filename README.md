
# Student Management System

A Java console application for managing student records. This project demonstrates object-oriented programming, data structures, and basic algorithms using Java.

## Features

- Add new students
- Display all students
- Search students by ID using Linear Search
- Prevent duplicate student IDs
- Update student details
- Delete student records
- Sort students by marks using Bubble Sort
- Calculate average marks

## Technologies Used

- Java 24
- Maven
- IntelliJ IDEA
- Git and GitHub

## Data Structures and Algorithms

- **ArrayList:** Stores student records in memory.
- **Linear Search:** Finds students by ID.
- **Bubble Sort:** Sorts students from highest to lowest marks.

## Project Structure

```text
student-management-system/
├── src/
│   └── main/
│       └── java/
│           └── lk/
│               └── ravindu/
│                   ├── Main.java
│                   ├── Student.java
│                   └── StudentService.java
├── .gitignore
├── pom.xml
└── README.md
```

## How to Run

1. Install JDK 24 or a compatible Java version.
2. Clone this repository:

   ```bash
   git clone https://github.com/ravinduvimukthi/student-management-system.git
   ```

3. Open the project in IntelliJ IDEA.
4. Load the Maven project.
5. Run `Main.java`.

## Current Limitations

- Student records are stored in memory and are lost when the program exits.
- The application runs in the console.
- Input validation can be improved.

## Future Improvements

- Save student records to a file or database.
- Improve input validation and error handling.
- Add automated unit tests.

## Author

Ravindu Vimukthi
