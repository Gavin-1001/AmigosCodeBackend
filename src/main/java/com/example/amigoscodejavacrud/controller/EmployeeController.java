package com.example.amigoscodejavacrud.controller;

import com.example.amigoscodejavacrud.entity.Employee;
import com.example.amigoscodejavacrud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") //this is the base url e.g localhost:8080/employee/add...
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //returns the employees in the application

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() { //returns a list of employees in the body
        List<Employee> employees = employeeService.findAllEmployees(); //returns a list of employees
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") Long id) { //the @Pathvariable (both @PathVariable id and the id of the url mapping should be the same)
        //I think it is just a check
        Employee employees = employeeService.findEmployeeById(id); //returns a list of employees
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
