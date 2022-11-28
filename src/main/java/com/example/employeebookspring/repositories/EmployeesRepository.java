package com.example.employeebookspring.repositories;

import com.example.employeebookspring.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeesRepository {
    private static int id;
    private final List<Employee> employeeList;

    public EmployeesRepository(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public List<Employee> getEmployeeList(){
        return employeeList;
    }
    public void addEmoloyee(Employee employee){
        employeeList.add(employee);
    }

    public static int getId() {
        return id;
    }
}
