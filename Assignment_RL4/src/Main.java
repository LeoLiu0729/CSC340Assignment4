import java.io.IOException;
import java.util.Scanner;

//main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        //Menu
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add new student");
            System.out.println("2. View all students");
            System.out.println("3. Update student data");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            //Using the switch case to enter information
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student class year: ");
                        int classYear = scanner.nextInt();
                        StudentManager.addStudent(new Student(id, name, classYear));
                        break;
                    case 2:
                        for (Student student : StudentManager.getAllStudents()) {
                            System.out.println(student);
                        }
                        System.out.println("You can also view all students in the 'students.txt' file.");
                        break;
                    case 3:
                        System.out.print("Enter student ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new class year: ");
                        int newClassYear = scanner.nextInt();
                        StudentManager.updateStudent(updateId, newName, newClassYear);
                        break;
                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = scanner.nextInt();
                        StudentManager.deleteStudent(deleteId);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);

        scanner.close();
    }
}
