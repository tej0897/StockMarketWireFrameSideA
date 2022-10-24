package com.example.fullStackDev.Controller;

import com.example.fullStackDev.Model.Employee;
import com.example.fullStackDev.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    @GetMapping("/getAllEmp")
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        if (employeeList!=null){
            return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Employee List is Empty", HttpStatus.NO_CONTENT);
    }

    @PostMapping("/addEmp")
    public ResponseEntity<?> addEmployee(Employee employee){
        if (employeeService.addEmployee(employee)!= null){
            return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Invalid Operation: ", HttpStatus.CONFLICT);
    }

    @DeleteMapping("/deleteEmp")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
        if (employeeService.removeEmployee(id)){
            return new ResponseEntity<String>("Employee Record is deleted. (y)", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("Error in Deleting Employee data. :(", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee)) {
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Error in Deleting Employee data. :(", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
