package manager;

import model.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherManager {

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Add Teacher
    public void addTeacher() {

        System.out.println("\n========== Add Teacher ==========");

        String id;

        while (true) {

            System.out.print("Teacher ID: ");
            id = input.nextLine();

            if (isDuplicateId(id)) {
                System.out.println("Teacher ID already exists!");
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

        System.out.print("Department: ");
        String department = input.nextLine();

        Teacher teacher = new Teacher(id, name, age, email, department);

        teachers.add(teacher);

        System.out.println("\nTeacher Added Successfully!");

    }

    // View Teachers
    public void viewTeachers() {

        System.out.println("\n========== Teacher List ==========");

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

        System.out.println("Teacher Not Found.");

        return null;

    }

    // Update Teacher
    public void updateTeacher() {

        Teacher teacher = searchTeacher();

        if (teacher == null)
            return;

        System.out.print("New Name: ");
        teacher.setName(input.nextLine());

        try {

            System.out.print("New Age: ");
            teacher.setAge(Integer.parseInt(input.nextLine()));

        } catch (NumberFormatException e) {

            System.out.println("Invalid Age. Previous age kept.");

        }

        System.out.print("New Email: ");
        teacher.setEmail(input.nextLine());

        System.out.print("New Department: ");
        teacher.setDepartment(input.nextLine());

        System.out.println("Teacher Updated Successfully.");

    }

    // Delete Teacher
    public void deleteTeacher() {

        Teacher teacher = searchTeacher();

        if (teacher == null)
            return;

        teachers.remove(teacher);

        System.out.println("Teacher Deleted Successfully.");

    }

    // Duplicate ID Check
    private boolean isDuplicateId(String id) {

        for (Teacher teacher : teachers) {

            if (teacher.getId().equalsIgnoreCase(id)) {

                return true;

            }

        }

        return false;

    }

    public ArrayList<Teacher> getTeachers() {

        return teachers;

    }

}