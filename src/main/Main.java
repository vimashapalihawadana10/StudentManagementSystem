package main;

import manager.CourseManager;
import manager.EnrollmentManager;
import manager.StudentManager;
import manager.TeacherManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();
        CourseManager courseManager = new CourseManager(teacherManager);
        EnrollmentManager enrollmentManager =
                new EnrollmentManager(studentManager, courseManager);

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Course Management");
            System.out.println("4. Enrollment Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    studentMenu(studentManager, input);
                    break;

                case 2:
                    teacherMenu(teacherManager, input);
                    break;

                case 3:
                    courseMenu(courseManager, input);
                    break;

                case 4:
                    enrollmentMenu(enrollmentManager, input);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 5);

    }

    // Student Menu
    public static void studentMenu(StudentManager manager, Scanner input) {

        int choice;

        do {

            System.out.println("\n===== Student Menu =====");
            System.out.println("1. Add  Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    manager.addStudent();
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    manager.searchStudent();
                    break;

                case 4:
                    manager.updateStudent();
                    break;

                case 5:
                    manager.deleteStudent();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

    }

    // Teacher Menu
    public static void teacherMenu(TeacherManager manager, Scanner input) {

        int choice;

        do {

            System.out.println("\n===== Teacher Menu =====");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Search Teacher");
            System.out.println("4. Update Teacher");
            System.out.println("5. Delete Teacher");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    manager.addTeacher();
                    break;

                case 2:
                    manager.viewTeachers();
                    break;

                case 3:
                    manager.searchTeacher();
                    break;

                case 4:
                    manager.updateTeacher();
                    break;

                case 5:
                    manager.deleteTeacher();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

    }

    // Course Menu
    public static void courseMenu(CourseManager manager, Scanner input) {

        int choice;

        do {

            System.out.println("\n===== Course Menu =====");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    manager.addCourse();
                    break;

                case 2:
                    manager.viewCourses();
                    break;

                case 3:
                    manager.searchCourse();
                    break;

                case 4:
                    manager.updateCourse();
                    break;

                case 5:
                    manager.deleteCourse();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

    }

    // Enrollment Menu
    public static void enrollmentMenu(EnrollmentManager manager, Scanner input) {

        int choice;

        do {

            System.out.println("\n===== Enrollment Menu =====");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments");
            System.out.println("3. Remove Enrollment");
            System.out.println("4. Back");
            System.out.print("Enter Choice : ");

            choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    manager.enrollStudent();
                    break;

                case 2:
                    manager.viewEnrollments();
                    break;

                case 3:
                    manager.removeEnrollment();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 4);

    }

}