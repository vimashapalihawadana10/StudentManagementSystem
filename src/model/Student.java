package model;

public class Student extends Person {

    public Student() {

    }

    public Student(String id, String name, int age, String email) {
        super(id, name, age, email);
    }

    @Override
    public void displayInfo() {

        System.out.println("------------------------");
        System.out.println("Student ID : " + getId());
        System.out.println("Name       : " + getName());
        System.out.println("Age        : " + getAge());
        System.out.println("Email      : " + getEmail());
    }

}
