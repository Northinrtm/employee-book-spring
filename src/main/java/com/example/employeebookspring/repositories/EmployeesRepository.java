package com.example.employeebookspring.repositories;

import com.example.employeebookspring.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class EmployeesRepository {
    private static int id;
    private final Collection<Employee> employeeCollection;

    public EmployeesRepository(Collection<Employee> employeeList) {
        this.employeeCollection = employeeList;
    }
    public Collection<Employee> getEmployeeCollection(){
        return employeeCollection;
    }
    public void addEmoloyee(Employee employee){
        employeeCollection.add(employee);
    }

    public static int getId() {
        return id;
    }
}
