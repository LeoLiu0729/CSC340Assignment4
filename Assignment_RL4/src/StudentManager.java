import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    // Output to the file call student.txt
    private static final String FILENAME = "students.txt";

    //Adding the student and using the throws IOException for get all the students.
    public static void addStudent(Student student) throws IOException {
        List<Student> students = getAllStudents();
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("A student with ID " + student.getId() + " already exists.");
                return;
            }
        }
        students.add(student);
        saveAllStudents(students);
        System.out.println("Student added successfully!");
    }
    // Same here getAll students and BufferedReader and FileReader and I also sorted the id which mean that
    // It can sorted the id such as ID:1,ID:2 by order.
    public static List<Student> getAllStudents() throws IOException {
        File file = new File(FILENAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                    .map(Student::fromString)
                    .sorted(Comparator.comparingInt(Student::getId))
                    .collect(Collectors.toList());
        }
    }

    // Update the Student information just like Add student
    public static void updateStudent(int id, String newName, int newClassYear) throws IOException {
        List<Student> students = getAllStudents();
        boolean updated = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                students.add(new Student(id, newName, newClassYear));
                updated = true;
                break;
            }
        }
        if (!updated) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }
        saveAllStudents(students);
        System.out.println("Student updated successfully!");
    }

    //    // delete student information by using the remove by the ID and ALl students.
    public static void deleteStudent(int id) throws IOException {
        List<Student> students = getAllStudents();
        students.removeIf(student -> student.getId() == id);
        saveAllStudents(students);
        System.out.println("Student deleted successfully!");
    }

    //It saving the students data to the students.txt by using writer
    private static void saveAllStudents(List<Student> students) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Student student : students) {
                writer.println(student);
            }
        }
    }
}
