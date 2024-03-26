import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    private static Map<Integer, Student> students = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Student Management System!");
        
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudentDetails();
                    break;
                case 3:
                    searchStudentByRollNumber();
                    break;
                case 4:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter Grade: ");
        String grade = scanner.next();
        
        Student student = new Student(rollNumber, name, age, grade);
        students.put(rollNumber, student);
        
        System.out.println("Student added successfully.");
    }
    
    private static void displayStudentDetails() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student Details:");
            for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
    
    private static void searchStudentByRollNumber() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Roll Number to search: ");
        int rollNumber = scanner.nextInt();
        
        Student student = students.get(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
}

class Student {
    private int rollNumber;
    private String name;
    private int age;
    private String grade;
    
    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    
    @Override
    public String toString() {
        return "Roll Number: " + rollNumber +
               ", Name: " + name +
               ", Age: " + age +
               ", Grade: " + grade;
    }
}