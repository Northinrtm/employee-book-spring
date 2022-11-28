package com.example.employeebookspring.service;

import com.example.employeebookspring.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private final Employee employeeSpy = spy(Employee.class);

    @InjectMocks
    private EmployeeService out;

    @Test
    void getAllEmployeesInDep() {

        when(out.getAllEmployeesInDep())
                .thenReturn(Collection<Employee>);
    }

    @Test
    void getSumSalaryDep() {
    }

    @Test
    void getMaxSalaryDep() {
    }

    @Test
    void getMinSalaryDep() {
    }

    @Test
    void integerEmployeeMap() {
    }
}