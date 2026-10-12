import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        StudentService studentService = new StudentService();
        StudentFileService fileService = new StudentFileService();

        try {
            studentService.loadStudents(fileService.loadStudents());
             System.out.println("Student records loaded successfully.");
      } catch (java.io.IOException e) {
        System.out.println("Error loading student records: " + e.getMessage());
}


System.out.println("DEBUG: Loaded students = "
        + studentService.getAllStudents().size());

        System.out.println("================================");
        System.out.println("  Student Management System");
        System.out.println("================================");

        while (true) {
            System.out.println("\n1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Calculate Average Marks");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter student ID: ");
                    int id;
                    try{
                        id = Integer.parseInt(scanner.nextLine());

                    }catch(NumberFormatException e){
                        System.out.println("Invalid ID. please enter a whole number.");
                        break;
                    }

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine().trim();
                    if(name.isEmpty()){
                        System.out.println("Student name cannot be empty");
                        break;
                    }

                    System.out.print("Enter course: ");
                    String course =scanner.nextLine().trim();

                    if(course.isEmpty()){
                        System.out.println("Course name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter marks: ");
                    double marks;
                    try{
                        marks=Double.parseDouble(scanner.nextLine());

                    }catch (NumberFormatException e){
                        System.out.println("Invalid marks.please enter a number");
                        break;
                    }

                    if(marks<0 || marks>100){
                        System.out.println("Invalid marks.Marks must be between 0 and 100");
                    }

                    Student student = new Student(id, name, course, marks);
                    studentService.addStudent(student);
                    try {
                          fileService.saveStudents(studentService.getAllStudents());
                          System.out.println("Student records saved successfully.");
                         } catch (java.io.IOException e) {
                           System.out.println("Error saving student records: " + e.getMessage());
                        }
                    break;


                case "2":
                    studentService.displayAllStudents();
                    break;


                case "3":
                    System.out.println("Enter student ID to search: ");
                    int searchId = Integer.parseInt(scanner.nextLine());

                    Student found = studentService.findStudentById(searchId);

                    if (found != null) {
                        System.out.println("Student found!");
                        System.out.println("ID: " + found.getId());
                        System.out.println("Name: :" + found.getName());
                        System.out.println("Course: " + found.getCourse());
                        System.out.println("Marks: " + found.getMarks());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case "4":
                    System.out.println("Enter student ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = scanner.nextLine().trim();

                    if(newCourse.isEmpty()){
                        System.out.println("Course name cannot be empty.");
                        break;
                    }


                    System.out.print("Enter new marks: ");
                    double newMarks;
                    try{
                        newMarks=Double.parseDouble(scanner.nextLine());

                    }catch (NumberFormatException e){
                        System.out.println("Invalid marks.please enter a number");
                        break;
                    }
                    if(newMarks<0 || newMarks>100){
                        System.out.println("Invalid marks.Marks must be between 0 and 100");
                    }

                    boolean updated = studentService.updateStudent(updateId, newName, newCourse, newMarks);

                    if (updated) {
                        System.out.println("\n --Updated Student Details--");
                        Student updateStudent =studentService.findStudentById(updateId);
                        System.out.println("ID: "+updateStudent.getId() );
                        System.out.println("Name: "+updateStudent.getName());
                        System.out.println("Marks: "+updateStudent.getMarks());

                        try{
                            fileService.saveStudents(studentService.getAllStudents());
                            System.out.println("Student records saved successfully");


                        }catch (java.io.IOException e) {
                            System.out.println("Error saving student records: " + e.getMessage());



                        }



                    } 
                    else{
                        System.out.println("Student not found!");
                    }
                    break;


                case "5":
                    System.out.println("Enter student ID to delete: ");
                    int deletedId = Integer.parseInt(scanner.nextLine());

                    boolean deleted = studentService.deleteStudent(deletedId);

                    if (deleted) {
                        System.out.println("Student deleted Successfully!");

                    } else {
                        System.out.println("Student not found");

                    }
                    break;



                case "6":
                    var sortedStudents = studentService.sortStudentsByMarks();

                    if (sortedStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n--- Students Sorted by Marks ---");


                        for (Student sortedStudent : sortedStudents) {
                            System.out.println(
                                    "ID: " + sortedStudent.getId()
                                            + " | Name: " + sortedStudent.getName()
                                            + " | Marks: " + sortedStudent.getMarks()
                            );
                        }

                    }
                    break;

                case "7":
                    double average=studentService.calculateAverageMarks();
                    System.out.printf("Average Marks: %.2f%n", average);
                    break;


                case "0":
                        System.out.println("Thank you for using this program.");
                        scanner.close();
                        return;

                default:
                    System.out.println("Invalid choice .please try again");



        }
        }
    }
}
