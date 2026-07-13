package model;

public class Course {

    private String courseId;
    private String courseName;
    private Teacher teacher;

    public Course() {

    }

    public Course(String courseId, String courseName, Teacher teacher) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void displayCourse() {

        System.out.println("------------------------");
        System.out.println("Course ID   : " + courseId);
        System.out.println("Course Name : " + courseName);

        if (teacher != null) {
            System.out.println("Teacher     : " + teacher.getName());
        }

    }

}

