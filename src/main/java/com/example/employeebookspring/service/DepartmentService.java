package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.repositories.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeesRepository employeesRepository;

    public DepartmentService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public Collection<Employee> getAllEmployeesInDep(int i) {
        return employeesRepository.getEmployeeCollection()
                .stream()
                .filter(e -> e.getDepartament() == i)
                .collect(Collectors.toList());
    }

    public int getSumSalaryDep(int i) {
        return getAllEmployeesInDep(i).stream()
                .mapToInt(e -> e.getSalary())
                .sum();
    }

    public int getMaxSalaryDep(int i) {
        return getAllEmployeesInDep(i)
                .stream()
                .mapToInt(e -> e.getSalary())
                .max()
                .getAsInt();
    }

    public int getMinSalaryDep(int i) {
        return getAllEmployeesInDep(i)
                .stream()
                .mapToInt(e -> e.getSalary())
                .min()
                .getAsInt();
    }

    public Map<Integer, List<Employee>> integerEmployeeMap() {
        Map<Integer, List<Employee>> employeeMap1 = new HashMap<>();
        for (Employee e : employeesRepository.getEmployeeCollection()) {
            if (employeeMap1.containsKey(e.getDepartament())) {
                employeeMap1.get(e.getDepartament()).add(e);
            } else {
                List<Employee> list = new ArrayList<>();
                list.add(e);
                employeeMap1.put(e.getDepartament(), list);
            }
        }
        return employeeMap1;
    }
}
