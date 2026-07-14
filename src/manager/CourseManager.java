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

        System.out.println("\n========== Add Course ==========");

        String courseId;

        while (true) {

            System.out.print("Course ID: ");
            courseId = input.nextLine();

            if (isDuplicateCourse(courseId)) {
                System.out.println("Course ID already exists!");
            } else {
                break;
            }

        }

        String courseName;

        while (true) {

            System.out.print("Course Name: ");
            courseName = input.nextLine();

            if (!courseName.trim().isEmpty()) {
                break;
            }

            System.out.println("Course name cannot be empty.");

        }

        if (teacherManager.getTeachers().isEmpty()) {

            System.out.println("No teachers available.");
            return;

        }

        System.out.println("\nAvailable Teachers");

        for (Teacher teacher : teacherManager.getTeachers()) {

            System.out.println(teacher.getId() + " - " + teacher.getName());

        }

        Teacher teacher = null;

        while (teacher == null) {

            System.out.print("Enter Teacher ID: ");
            String teacherId = input.nextLine();

            teacher = findTeacher(teacherId);

            if (teacher == null) {

                System.out.println("Teacher Not Found!");

            }

        }

        Course course = new Course(courseId, courseName, teacher);

        courses.add(course);

        System.out.println("Course Added Successfully!");

    }

    // View Courses
    public void viewCourses() {

        System.out.println("\n========== Course List ==========");

        if (courses.isEmpty()) {

            System.out.println("No courses available.");

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

        System.out.println("Course Not Found.");

        return null;

    }

    // Update Course
    public void updateCourse() {

        Course course = searchCourse();

        if (course == null)
            return;

        System.out.print("New Course Name: ");
        course.setCourseName(input.nextLine());

        System.out.println("Course Updated Successfully.");

    }

    // Delete Course
    public void deleteCourse() {

        Course course = searchCourse();

        if (course == null)
            return;

        courses.remove(course);

        System.out.println("Course Deleted Successfully.");

    }

    // Helper Method
    private boolean isDuplicateCourse(String id) {

        for (Course course : courses) {

            if (course.getCourseId().equalsIgnoreCase(id)) {

                return true;

            }

        }

        return false;

    }

    // Helper Method
    private Teacher findTeacher(String id) {

        for (Teacher teacher : teacherManager.getTeachers()) {

            if (teacher.getId().equalsIgnoreCase(id)) {

                return teacher;

            }

        }

        return null;

    }

    public ArrayList<Course> getCourses() {

        return courses;

    }

}