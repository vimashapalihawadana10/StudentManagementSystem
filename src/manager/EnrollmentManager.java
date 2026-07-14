package manager;

import model.Course;
import model.Enrollment;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class EnrollmentManager {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    private StudentManager studentManager;
    private CourseManager courseManager;

    private Scanner input = new Scanner(System.in);

    public EnrollmentManager(StudentManager studentManager, CourseManager courseManager) {

        this.studentManager = studentManager;
        this.courseManager = courseManager;

    }

    // Enroll Student
    public void enrollStudent() {

        System.out.println("\n========== Student Enrollment ==========");

        if (studentManager.getStudents().isEmpty()) {

            System.out.println("No students available.");
            return;

        }

        if (courseManager.getCourses().isEmpty()) {

            System.out.println("No courses available.");
            return;

        }

        System.out.println("\nAvailable Students");

        for (Student student : studentManager.getStudents()) {

            System.out.println(student.getId() + " - " + student.getName());

        }

        System.out.print("Enter Student ID: ");
        String studentId = input.nextLine();

        Student student = findStudent(studentId);

        if (student == null) {

            System.out.println("Student Not Found!");
            return;

        }

        System.out.println("\nAvailable Courses");

        for (Course course : courseManager.getCourses()) {

            System.out.println(course.getCourseId() + " - " + course.getCourseName());

        }

        System.out.print("Enter Course ID: ");
        String courseId = input.nextLine();

        Course course = findCourse(courseId);

        if (course == null) {

            System.out.println("Course Not Found!");
            return;

        }

        if (alreadyEnrolled(student, course)) {

            System.out.println("Student is already enrolled in this course!");
            return;

        }

        enrollments.add(new Enrollment(student, course));

        System.out.println("Enrollment Successful!");

    }

    // View Enrollments
    public void viewEnrollments() {

        System.out.println("\n========== Enrollment List ==========");

        if (enrollments.isEmpty()) {

            System.out.println("No enrollments found.");
            return;

        }

        for (Enrollment enrollment : enrollments) {

            enrollment.displayEnrollment();

        }

    }

    // Remove Enrollment
    public void removeEnrollment() {

        System.out.print("Student ID: ");
        String studentId = input.nextLine();

        System.out.print("Course ID: ");
        String courseId = input.nextLine();

        Enrollment removeEnrollment = null;

        for (Enrollment enrollment : enrollments) {

            if (enrollment.getStudent().getId().equalsIgnoreCase(studentId)
                    &&
                    enrollment.getCourse().getCourseId().equalsIgnoreCase(courseId)) {

                removeEnrollment = enrollment;
                break;

            }

        }

        if (removeEnrollment == null) {

            System.out.println("Enrollment Not Found.");
            return;

        }

        enrollments.remove(removeEnrollment);

        System.out.println("Enrollment Removed Successfully!");

    }

    // Helper Methods

    private Student findStudent(String id) {

        for (Student student : studentManager.getStudents()) {

            if (student.getId().equalsIgnoreCase(id)) {

                return student;

            }

        }

        return null;

    }

    private Course findCourse(String id) {

        for (Course course : courseManager.getCourses()) {

            if (course.getCourseId().equalsIgnoreCase(id)) {

                return course;

            }

        }

        return null;

    }

    private boolean alreadyEnrolled(Student student, Course course) {

        for (Enrollment enrollment : enrollments) {

            if (enrollment.getStudent().getId().equalsIgnoreCase(student.getId())
                    &&
                    enrollment.getCourse().getCourseId().equalsIgnoreCase(course.getCourseId())) {

                return true;

            }

        }

        return false;

    }

}