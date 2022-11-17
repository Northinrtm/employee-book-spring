package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

}
