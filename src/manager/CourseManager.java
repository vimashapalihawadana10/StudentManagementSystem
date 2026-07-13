package manager;

import model.Course;
import model.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {

    private ArrayList<Course> courses = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private TeacherManager teacherManager;

    public CourseManager(TeacherManager teacherManager) {
        this.teacherManager = teacherManager;
    }

    // Add Course
    public void addCourse() {

        System.out.println("\n===== Add Course =====");

        System.out.print("Course ID: ");
        String courseId = input.nextLine();

        System.out.print("Course Name: ");
        String courseName = input.nextLine();

        if (teacherManager.getTeachers().isEmpty()) {
            System.out.println("No teachers available. Please add a teacher first.");
            return;
        }

        System.out.println("\nAvailable Teachers");

        for (Teacher teacher : teacherManager.getTeachers()) {
            System.out.println(teacher.getId() + " - " + teacher.getName());
        }

        System.out.print("Enter Teacher ID: ");
        String teacherId = input.nextLine();

        Teacher selectedTeacher = null;

        for (Teacher teacher : teacherManager.getTeachers()) {

            if (teacher.getId().equalsIgnoreCase(teacherId)) {
                selectedTeacher = teacher;
                break;
            }

        }

        if (selectedTeacher == null) {
            System.out.println("Teacher Not Found!");
            return;
        }

        Course course = new Course(courseId, courseName, selectedTeacher);

        courses.add(course);

        System.out.println("Course Added Successfully!");

    }

    // View Courses
    public void viewCourses() {

        System.out.println("\n===== Course List =====");

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        for (Course course : courses) {
            course.displayCourse();
        }

    }

    // Search Course
    public Course searchCourse() {

        System.out.print("Enter Course ID: ");
        String id = input.nextLine();

        for (Course course : courses) {

            if (course.getCourseId().equalsIgnoreCase(id)) {

                course.displayCourse();

                return course;

            }

        }

        System.out.println("Course Not Found!");

        return null;

    }

    // Update Course
    public void updateCourse() {

        System.out.print("Enter Course ID: ");
        String id = input.nextLine();

        for (Course course : courses) {

            if (course.getCourseId().equalsIgnoreCase(id)) {

                System.out.print("New Course Name: ");
                course.setCourseName(input.nextLine());

                System.out.println("Course Updated!");

                return;

            }

        }

        System.out.println("Course Not Found!");

    }

    // Delete Course
    public void deleteCourse() {

        System.out.print("Enter Course ID: ");
        String id = input.nextLine();

        Course deleteCourse = null;

        for (Course course : courses) {

            if (course.getCourseId().equalsIgnoreCase(id)) {

                deleteCourse = course;

                break;

            }

        }

        if (deleteCourse != null) {

            courses.remove(deleteCourse);

            System.out.println("Course Deleted!");

        } else {

            System.out.println("Course Not Found!");

        }

    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

}
