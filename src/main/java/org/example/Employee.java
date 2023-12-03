package org.example;

public class Employee {

    // 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
    private String name;
    private int age;
    private double salary;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee (" +
                "name: " + name +
                ", age: " + age +
                ", salary: " + salary +
                ", department: " + department + ")";
    }
}
