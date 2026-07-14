package main;

import manager.CourseManager;
import manager.EnrollmentManager;
import manager.StudentManager;
import manager.TeacherManager;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static StudentManager studentManager = new StudentManager();
    static TeacherManager teacherManager = new TeacherManager();
    static CourseManager courseManager = new CourseManager(teacherManager);
    static EnrollmentManager enrollmentManager =
            new EnrollmentManager(studentManager, courseManager);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Course Management");
            System.out.println("4. Enrollment Management");
            System.out.println("5. Exit");
            System.out.println("======================================");

            int choice = getChoice();

            switch (choice) {

                case 1:
                    studentMenu();
                    break;

                case 2:
                    teacherMenu();
                    break;

                case 3:
                    courseMenu();
                    break;

                case 4:
                    enrollmentMenu();
                    break;

                case 5:
                    System.out.println("\nThank you for using the system!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");

            }

        }

    }

    // Read menu choice safely
    public static int getChoice() {

        while (true) {

            try {

                System.out.print("Enter Choice : ");

                return Integer.parseInt(input.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter numbers only.");

            }

        }

    }

    // Student Menu
    public static void studentMenu() {

        while (true) {

            System.out.println("\n----- Student Menu -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back");

            int choice = getChoice();

            switch (choice) {

                case 1 -> studentManager.addStudent();
                case 2 -> studentManager.viewStudents();
                case 3 -> studentManager.searchStudent();
                case 4 -> studentManager.updateStudent();
                case 5 -> studentManager.deleteStudent();
                case 6 -> { return; }
                default -> System.out.println("Invalid Choice!");

            }

        }

    }

    // Teacher Menu
    public static void teacherMenu() {

        while (true) {

            System.out.println("\n----- Teacher Menu -----");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Search Teacher");
            System.out.println("4. Update Teacher");
            System.out.println("5. Delete Teacher");
            System.out.println("6. Back");

            int choice = getChoice();

            switch (choice) {

                case 1 -> teacherManager.addTeacher();
                case 2 -> teacherManager.viewTeachers();
                case 3 -> teacherManager.searchTeacher();
                case 4 -> teacherManager.updateTeacher();
                case 5 -> teacherManager.deleteTeacher();
                case 6 -> { return; }
                default -> System.out.println("Invalid Choice!");

            }

        }

    }

    // Course Menu
    public static void courseMenu() {

        while (true) {

            System.out.println("\n----- Course Menu -----");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Back");

            int choice = getChoice();

            switch (choice) {

                case 1 -> courseManager.addCourse();
                case 2 -> courseManager.viewCourses();
                case 3 -> courseManager.searchCourse();
                case 4 -> courseManager.updateCourse();
                case 5 -> courseManager.deleteCourse();
                case 6 -> { return; }
                default -> System.out.println("Invalid Choice!");

            }

        }

    }

    // Enrollment Menu
    public static void enrollmentMenu() {

        while (true) {

            System.out.println("\n----- Enrollment Menu -----");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments");
            System.out.println("3. Remove Enrollment");
            System.out.println("4. Back");

            int choice = getChoice();

            switch (choice) {

                case 1 -> enrollmentManager.enrollStudent();
                case 2 -> enrollmentManager.viewEnrollments();
                case 3 -> enrollmentManager.removeEnrollment();
                case 4 -> { return; }
                default -> System.out.println("Invalid Choice!");

            }

        }

    }

}