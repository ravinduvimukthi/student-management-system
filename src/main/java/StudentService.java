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
    public boolean updateStudent(int id,String name,String course,double marks){
        Student student =findStudentById(id);
        if(student == null){
            return false;

        }
        student.setName(name);
        student.setCourse(course);
        student.setMarks(marks);

        return true;
    }

    public boolean deleteStudent(int id){
        Student student = findStudentById(id);
        if(student == null){
            return false;

        }
        students.remove(student);
        return true;
    }

    public List<Student> sortStudentsByMarks() {
        List<Student> sortedStudents = new ArrayList<>(students);

        for (int i = 0; i < sortedStudents.size() - 1; i++) {
            for (int j = 0; j < sortedStudents.size() - i - 1; j++) {
                if (sortedStudents.get(j).getMarks()
                        < sortedStudents.get(j + 1).getMarks()) {

                    Student temp = sortedStudents.get(j);
                    sortedStudents.set(j, sortedStudents.get(j + 1));
                    sortedStudents.set(j + 1, temp);
                }
            }
        }

        return sortedStudents;
    }

    public double calculateAverageMarks() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (Student student : students) {
            total = total + student.getMarks();
        }

        return total / students.size();
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
