package com.example.fullStackDev.Repository;

import com.example.fullStackDev.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
