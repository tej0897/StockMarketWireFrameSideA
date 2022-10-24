package com.example.fullStackDev.Service;

import com.example.fullStackDev.Model.Employee;
import com.example.fullStackDev.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        if (employeeList.size() > 0) {
            return employeeList;
        } else {
            return null;
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee != null) {
            employeeRepo.saveAndFlush(employee);
            return employee;
        }
        return null;
    }

    @Override
    public boolean removeEmployee(int id) {
        employeeRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Employee employee1 = employeeRepo.getById(employee.getId());
        employee1.setName(employee.getName());
        employeeRepo.saveAndFlush(employee1);
        return false;
    }
}
