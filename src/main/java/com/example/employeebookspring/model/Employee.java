package com.example.employeebookspring.model;

public class Employee {
    private final String firstName, lastName;
    private final int id, departament, salary;
    private static int counter;

    public Employee(String firstName, String lastName, int departament, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
        this.salary = salary;
        this.id = counter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getDepartament() {
        return departament;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", departament=" + departament +
                ", salary=" + salary +
                '}';
    }
}
