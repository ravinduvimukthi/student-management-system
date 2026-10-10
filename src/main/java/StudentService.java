import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
       if(findStudentById(student.getId()) != null){
           System.out.println("Error: student ID alreeady exists!");
           return;
       }
       students.add(student);
        System.out.println("Student added successfully!");
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
    public void displayAllStudents(){
        if(students.isEmpty()){
            System.out.println("NO students found!");
            return;
        }
        System.out.println("\n--- student List ---");
        for (Student student :students){
            System.out.println("ID: "+student.getId());
            System.out.println("Name: "+student.getName());
            System.out.println("course: "+student.getCourse());
            System.out.println("Marks: "+student.getMarks());
        }
    }

}
