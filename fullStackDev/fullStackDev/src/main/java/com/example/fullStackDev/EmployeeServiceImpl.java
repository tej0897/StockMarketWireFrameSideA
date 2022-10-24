package com.example.fullStackDev;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private List<Employee> employeeList = new ArrayList<Employee>();
    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }
}
