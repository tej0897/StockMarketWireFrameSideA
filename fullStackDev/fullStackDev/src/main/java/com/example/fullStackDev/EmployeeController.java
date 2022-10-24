package com.example.fullStackDev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;


    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeServiceImpl.addEmployee(employee);
        return employee;
    }

    @GetMapping("/getAllEmp")
    public List<Employee> getAllEmployees(){
        return employeeServiceImpl.getAllEmployees();
    }
}
