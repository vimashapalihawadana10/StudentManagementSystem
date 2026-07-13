package manager;

import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Add Student
    public void addStudent() {

        System.out.println("\n===== Add Student =====");

        System.out.print("Student ID: ");
        String id = input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Email: ");
        String email = input.nextLine();

        Student student = new Student(id, name, age, email);

        students.add(student);

        System.out.println("Student Added Successfully!");
    }

    // View Students
    public void viewStudents() {

        System.out.println("\n===== Student List =====");

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

        System.out.println("Student Not Found!");

        return null;
    }

    // Update Student
    public void updateStudent() {

        System.out.print("Enter Student ID: ");
        String id = input.nextLine();

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {

                System.out.print("New Name: ");
                student.setName(input.nextLine());

                System.out.print("New Age: ");
                student.setAge(Integer.parseInt(input.nextLine()));

                System.out.print("New Email: ");
                student.setEmail(input.nextLine());

                System.out.println("Student Updated!");

                return;
            }

        }

        System.out.println("Student Not Found!");

    }

    // Delete Student
    public void deleteStudent() {

        System.out.print("Enter Student ID: ");
        String id = input.nextLine();

        Student deleteStudent = null;

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {

                deleteStudent = student;
                break;

            }

        }

        if (deleteStudent != null) {

            students.remove(deleteStudent);

            System.out.println("Student Deleted!");

        } else {

            System.out.println("Student Not Found!");

        }

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
