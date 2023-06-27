package com.example.Employee.Management.System.controller;

import com.example.Employee.Management.System.model.Employee;
import com.example.Employee.Management.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("getAll")
    public Iterable getAllEmployee(){
        return employeeService.getAll();
    }

    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody Employee employee){

        return employeeService.updateEmployee(id,employee);
    }




}
