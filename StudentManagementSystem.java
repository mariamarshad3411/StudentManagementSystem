import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                displayAllStudents();
            } else if (choice == 3) {
                searchStudentById();
            } else if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Major: ");
        String major = scanner.nextLine();
        System.out.print("Enter GPA: ");
        double GPA = scanner.nextDouble();

        Student newStudent = new Student(name, age, address, major, GPA);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            student.displayDetails();
            System.out.println("-------------------");
        }
    }

    private static void searchStudentById() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                student.displayDetails();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
