package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    @BeforeEach
    void setUp() {
        EmployeeRequest employeeRequest1 = new EmployeeRequest();
        employeeRequest1.setSalary(1000);
        employeeRequest1.setDepartment(1);
        employeeRequest1.setFirstName("Ivan");
        employeeRequest1.setLastName("Ivanov");
        EmployeeRequest employeeRequest2 = new EmployeeRequest();
        employeeRequest2.setSalary(500);
        employeeRequest2.setDepartment(1);
        employeeRequest2.setFirstName("Petr");
        employeeRequest2.setLastName("Petrov");
        EmployeeRequest employeeRequest3 = new EmployeeRequest();
        employeeRequest3.setSalary(1500);
        employeeRequest3.setDepartment(2);
        employeeRequest3.setFirstName("Oleg");
        employeeRequest3.setLastName("Olegov");
        out.addEmployee(employeeRequest1);
        out.addEmployee(employeeRequest2);
        out.addEmployee(employeeRequest3);
    }

    @Test
    void getSumSalary() {
        int result = out.getSumSalary();
        assertEquals(3000, result);
    }

    @Test
    void getEmpMin() {
        int result = out.getEmpMin().getSalary();
        assertEquals(500, result);
    }

    @Test
    void getEmpMax() {
        int result = out.getEmpMax().getSalary();
        assertEquals(1500, result);
    }

    @Test
    void getEmpHighSalary() {
        Collection<Employee> result = out.getEmpHighSalary();
        Employee employee = new Employee("Oleg", "Olegov", 2, 1500);
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 1000);
        Collection<Employee> expected = new ArrayList<>();
        expected.add(employee1);
        expected.add(employee);
        assertEquals(expected, result);
    }
}