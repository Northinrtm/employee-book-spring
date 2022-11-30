package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employeeMap.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        this.employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public int getSumSalary() {
        return employeeMap.values()
                .stream()
                .mapToInt(employee -> employee.getSalary())
                .sum();
    }

    public Employee getEmpMin() {
        return employeeMap.values().stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("?????"));
    }

    public Employee getEmpMax() {
        return employeeMap.values().stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("?????"));
    }

    public Collection<Employee> getEmpHighSalary() {
        double average = employeeMap.values()
                .stream()
                .mapToInt(Employee::getSalary)
                .average()
                .getAsDouble();
        return employeeMap.values()
                .stream()
                .filter(employee -> (double) employee.getSalary() >= average)
                .collect(Collectors.toList());
    }
}
