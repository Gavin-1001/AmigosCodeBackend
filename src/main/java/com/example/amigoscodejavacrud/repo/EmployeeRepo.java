package com.example.amigoscodejavacrud.repo;

import com.example.amigoscodejavacrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    //This is called a query method because the spring recognises the find keyword and will query the db for finding see @35:10
    Optional<Employee> findEmployeeById(Long id);
}
