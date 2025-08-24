package com.codeWithProject.demo.controller;


import com.codeWithProject.demo.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codeWithProject.demo.service.EmployeeService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController
{
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee) {

        return employeeService.postEmployee(employee);
    }

    @GetMapping("/employee/test")
    public String testEmployeeEndpoint() {
        return "Employee API is up";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employee with id " + id + " deleted successfully.", HttpStatus.OK);
        }
        catch(EntityNotFoundException e){
            return new ResponseEntity<>("employee with id " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        {
               Employee employee = employeeService.getEmployeeById(id);
                if(employee== null) {
                    return  ResponseEntity.notFound().build();
                }
                else {
                    return ResponseEntity.ok(employee);
                }
        }
    }
    @PatchMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(updatedEmployee);
        }
    }


}
