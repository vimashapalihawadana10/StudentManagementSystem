package model;

public class Teacher extends Person {

    private String department;

    public Teacher() {

    }

    public Teacher(String id, String name, int age, String email, String department) {

        super(id, name, age, email);
        this.department = department;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayInfo() {

        System.out.println("------------------------");
        System.out.println("Teacher ID : " + getId());
        System.out.println("Name       : " + getName());
        System.out.println("Age        : " + getAge());
        System.out.println("Email      : " + getEmail());
        System.out.println("Department : " + department);

    }

}
