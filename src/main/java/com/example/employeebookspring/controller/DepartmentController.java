package com.example.employeebookspring.controller;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final EmployeeService employeeService;

    DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeesInDep(@PathVariable("id") int i) {
        return employeeService.getAllEmployeesInDep(i);
    }

    @GetMapping("/{id}/salary/sum")
    public int getAllSalaryDep(@PathVariable("id") int i) {
        return employeeService.getSumSalaryDep(i);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalaryDep(@PathVariable("id") int i) {
        return employeeService.getMaxSalaryDep(i);
    }

    @GetMapping("{id}/salary/min")
    public int getMinSalaryDep(@PathVariable("id") int i) {
        return employeeService.getMinSalaryDep(i);
    }

    @GetMapping("/employeesToMap")
    public Map<Integer, List<Employee>> integerEmployeeMap() {
        return employeeService.integerEmployeeMap();
    }
}