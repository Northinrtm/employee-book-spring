package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import com.example.employeebookspring.repositories.EmployeesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private final EmployeesRepository employeesRepository;

    @InjectMocks
    private DepartmentService departmentService;

    Collection<Employee> actualEmployees;

    DepartmentServiceTest(EmployeesRepository employeesRepository, DepartmentService departmentService) {
        this.employeesRepository = employeesRepository;
        this.departmentService = departmentService;
    }

    @BeforeEach
    public void setUp() {
        Employee employee = new Employee("Ivan", "Ivanov", 1, 1000);
        Employee employee1 = new Employee("Petr", "Petrov", 1, 1500);
        Employee employee2 = new Employee("Kostantin", "Kostantinov", 2, 500);

        actualEmployees.add(employee);
        actualEmployees.add(employee1);
        actualEmployees.add(employee2);

        Mockito.when(employeesRepository.getEmployeeCollection()).thenReturn(actualEmployees);
    }


    @Test
    void getAllEmployeesInDep() {
        final int department = 1;

        final Collection<Employee> actual = actualEmployees.stream()
                .filter(employee -> employee.getDepartament() == department)
                .collect(Collectors.toList());

        final Collection<Employee> expected = departmentService.getAllEmployeesInDep(department);

        assertEquals(expected, actual);
    }

    @Test
    void getSumSalaryDep() {
        final int department = 1;

        int actual = actualEmployees.stream()
                .filter(employee -> employee.getDepartament() == department)
                .mapToInt(Employee::getSalary)
                .sum();

        int expected = departmentService.getSumSalaryDep(department);

        assertEquals(actual, expected);
    }

    @Test
    void getMaxSalaryDep() {
        final int department = 1;

        int actual = actualEmployees.stream()
                .filter(employee -> employee.getDepartament() == department)
                .mapToInt(Employee::getSalary)
                .max()
                .getAsInt();

        int expected = departmentService.getMaxSalaryDep(department);

        assertEquals(actual, expected);
    }

    @Test
    void getMinSalaryDep() {
        final int department = 1;

        int actual = actualEmployees.stream()
                .filter(employee -> employee.getDepartament() == department)
                .mapToInt(Employee::getSalary)
                .min()
                .getAsInt();

        int expected = departmentService.getMinSalaryDep(department);

        assertEquals(actual, expected);
    }

    @Test
    void integerEmployeeMap() {
        Map<Integer, List<Employee>> actual = new HashMap<>();
        for (Employee e : actualEmployees) {
            if (actual.containsKey(e.getDepartament())) {
                actual.get(e.getDepartament()).add(e);
            } else {
                List<Employee> list = new ArrayList<>();
                list.add(e);
                actual.put(e.getDepartament(), list);
            }
        }


        Map<Integer,List<Employee>> expected = departmentService.integerEmployeeMap();

        assertEquals(actual, expected);
    }
}