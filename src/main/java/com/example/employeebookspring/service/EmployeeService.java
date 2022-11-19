package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employeeMap.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartament(),
                employeeRequest.getSalary());
        this.employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee employeeSalaryMax() {
        employeeMap.values()
                .stream()
                .map(employee -> employee.getSalary());
        return new Employee("1", "1", 1, 1);
    }
}
