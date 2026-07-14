package manager;

import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Add Student
    public void addStudent() {

        System.out.println("\n========== Add Student ==========");

        String id;

        while (true) {

            System.out.print("Student ID: ");
            id = input.nextLine();

            if (isDuplicateId(id)) {
                System.out.println("Student ID already exists!");
            } else {
                break;
            }
        }

        System.out.print("Name: ");
        String name = input.nextLine();

        int age;

        while (true) {

            try {

                System.out.print("Age: ");
                age = Integer.parseInt(input.nextLine());

                if (age <= 0) {
                    System.out.println("Age must be greater than 0.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            }

        }

        String email;

        while (true) {

            System.out.print("Email: ");
            email = input.nextLine();

            if (email.contains("@") && email.contains(".")) {
                break;
            }

            System.out.println("Invalid Email!");

        }

        Student student = new Student(id, name, age, email);

        students.add(student);

        System.out.println("\nStudent Added Successfully!");

    }

    // View Students
    public void viewStudents() {

        System.out.println("\n========== Student List ==========");

        if (students.isEmpty()) {

            System.out.println("No students found.");

            return;

        }

        for (Student student : students) {

            student.displayInfo();

        }

    }

    // Search Student
    public Student searchStudent() {

        System.out.print("Enter Student ID: ");
        String id = input.nextLine();

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {

                student.displayInfo();

                return student;

            }

        }

        System.out.println("Student Not Found.");

        return null;

    }

    // Update Student
    public void updateStudent() {

        Student student = searchStudent();

        if (student == null)
            return;

        System.out.print("New Name: ");
        student.setName(input.nextLine());

        try {

            System.out.print("New Age: ");
            student.setAge(Integer.parseInt(input.nextLine()));

        } catch (NumberFormatException e) {

            System.out.println("Invalid Age. Previous age kept.");

        }

        System.out.print("New Email: ");
        student.setEmail(input.nextLine());

        System.out.println("Student Updated Successfully.");

    }

    // Delete Student
    public void deleteStudent() {

        Student student = searchStudent();

        if (student == null)
            return;

        students.remove(student);

        System.out.println("Student Deleted Successfully.");

    }

    // Duplicate ID Checking
    private boolean isDuplicateId(String id) {

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {

                return true;

            }

        }

        return false;

    }

    public ArrayList<Student> getStudents() {

        return students;

    }

}