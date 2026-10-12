import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentFileService {

    private static final Path FILE_PATH = Path.of("students.txt");

    public void saveStudents(List<Student> students) throws IOException {
    List<String> lines = new ArrayList<>();

    for (Student student : students) {
        lines.add(String.valueOf(student.getId()));
        lines.add(student.getName());
        lines.add(student.getCourse());
        lines.add(String.valueOf(student.getMarks()));
    }

    Files.write(FILE_PATH, lines, StandardCharsets.UTF_8);
}
    public List<Student> loadStudents() throws IOException{
        List<Student> students=new ArrayList<>();
        if (!Files.exists(FILE_PATH)) {
            return students;

            
        }
        List<String> lines= Files.readAllLines(FILE_PATH,StandardCharsets.UTF_8);

        if (lines.size() % 4 != 0) {
    throw new IOException("Student file contains invalid data");
}
        for (int i = 0; i < lines.size(); i += 4){
            int id=Integer.parseInt(lines.get(i));
            String name =lines.get(i+1);
            String course =lines.get(i+2);
            double marks =Double.parseDouble(lines.get(i+3));

            students.add(new Student(id,name,course,marks));
        }
        return students;

    }


}
