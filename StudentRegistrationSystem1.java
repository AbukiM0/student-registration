import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StudentRegistrationSystem1 {

    private static List<Student> students = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    private static class Student {
        String studentId, firstName, lastName, dateOfBirth, program;

        public Student(String firstName, String lastName, String dateOfBirth, String program) {
            this.studentId = generateStudentId();
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.program = program;
        }
        
    }

    private static class User {
        String username, password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    private static String generateStudentId() {
        return UUID.randomUUID().toString();
    }

    private static void registerStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Enter Program: ");
        String program = scanner.nextLine();

        // Create a new student and add to the list
        students.add(new Student(firstName, lastName, dateOfBirth, program));

        System.out.println("Student registered successfully!");
    }

    private static void createUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username: ");
        String username = scanner.nextLine();

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        // Create a new user and add to the list
        users.add(new User(username, password));

        System.out.println("User created successfully!");
    }

    private static boolean authenticateUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username: ");
        String username = scanner.nextLine();

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        // Check if the user credentials are valid
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Authentication successful!");
                return true;
            }
        }

        System.out.println("Authentication failed. Invalid Username or Password.");
        return false;
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("Registered Students:");
            for (Student student : students) {
                System.out.println("Student ID: " + student.studentId);
                System.out.println("Name: " + student.firstName + " " + student.lastName);
                System.out.println("Date of Birth: " + student.dateOfBirth);
                System.out.println("Program: " + student.program);
                System.out.println("-------------------------");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register Student");
            System.out.println("2. Create User");
            System.out.println("3. Display Registered Students");
            System.out.println("4. Quit");

            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                if (authenticateUser()) {
                    registerStudent();
                }
            } else if ("2".equals(choice)) {
                createUser();
            } else if ("3".equals(choice)) {
                displayStudents();
            } else if ("4".equals(choice)) {
                System.exit(0);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
