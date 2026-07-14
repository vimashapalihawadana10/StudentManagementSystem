package model;

public class Enrollment {

    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {

        this.student = student;
        this.course = course;

    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void displayEnrollment() {

        System.out.println("------------------------");
        System.out.println("Student : " + student.getName());
        System.out.println("Course  : " + course.getCourseName());

    }

}