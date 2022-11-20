package com.example.employeebookspring.controller;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.record.EmployeeRequest;
import com.example.employeebookspring.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employee/salary/sum")
    public int getSumSalary() {
        return this.employeeService.getSumSalary();
    }

    @GetMapping("/employee/salary/min")
    public Employee getEmpMinSalary() {
        return this.employeeService.getEmpMin();
    }

    @GetMapping("/employee/salary/max")
    public Employee getEmpMaxSalary() {
        return this.employeeService.getEmpMax();
    }

    @GetMapping("/employee/high-salary")
    public Collection<Employee> getEmpHighSalary() {
        return this.employeeService.getEmpHighSalary();
    }
}
