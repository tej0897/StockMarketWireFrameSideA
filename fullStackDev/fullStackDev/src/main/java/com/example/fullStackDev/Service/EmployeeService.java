package com.example.fullStackDev.Service;

import com.example.fullStackDev.Model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee addEmployee(Employee employee);

    public boolean removeEmployee(int id);

    public boolean updateEmployee(Employee employee);
}
