package manager;

import model.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherManager {

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Add Teacher
    public void addTeacher() {

        System.out.println("\n===== Add Teacher =====");

        System.out.print("Teacher ID: ");
        String id = input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Department: ");
        String department = input.nextLine();

        Teacher teacher = new Teacher(id, name, age, email, department);

        teachers.add(teacher);

        System.out.println("Teacher Added Successfully!");
    }

    // View Teachers
    public void viewTeachers() {

        System.out.println("\n===== Teacher List =====");

        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        for (Teacher teacher : teachers) {
            teacher.displayInfo();
        }
    }

    // Search Teacher
    public Teacher searchTeacher() {

        System.out.print("Enter Teacher ID: ");
        String id = input.nextLine();

        for (Teacher teacher : teachers) {

            if (teacher.getId().equalsIgnoreCase(id)) {
                teacher.displayInfo();
                return teacher;
            }

        }

        System.out.println("Teacher Not Found!");

        return null;
    }

    // Update Teacher
    public void updateTeacher() {

        System.out.print("Enter Teacher ID: ");
        String id = input.nextLine();

        for (Teacher teacher : teachers) {

            if (teacher.getId().equalsIgnoreCase(id)) {

                System.out.print("New Name: ");
                teacher.setName(input.nextLine());

                System.out.print("New Age: ");
                teacher.setAge(Integer.parseInt(input.nextLine()));

                System.out.print("New Email: ");
                teacher.setEmail(input.nextLine());

                System.out.print("New Department: ");
                teacher.setDepartment(input.nextLine());

                System.out.println("Teacher Updated!");

                return;
            }

        }

        System.out.println("Teacher Not Found!");
    }

    // Delete Teacher
    public void deleteTeacher() {

        System.out.print("Enter Teacher ID: ");
        String id = input.nextLine();

        Teacher deleteTeacher = null;

        for (Teacher teacher : teachers) {

            if (teacher.getId().equalsIgnoreCase(id)) {

                deleteTeacher = teacher;
                break;

            }

        }

        if (deleteTeacher != null) {

            teachers.remove(deleteTeacher);

            System.out.println("Teacher Deleted!");

        } else {

            System.out.println("Teacher Not Found!");

        }

    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

}