package com.example.Employee.Management.System.service;

import com.example.Employee.Management.System.model.Employee;
import com.example.Employee.Management.System.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    public ResponseEntity<String> createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee created successfully with ID: "+employee.getId());
    }

    public Iterable getAll() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<String> updateEmployee(Long id, Employee employee) {
        Optional<Employee> employee1=employeeRepository.findById(id);
        if(employee1.isPresent()){
            Employee employee2=employee1.get();

            employee2.setFirstName(employee.getFirstName());
            employee2.setLastName(employee.getLastName());
            employee2.setPhoneNumber(employee.getPhoneNumber());
            employee2.setEmail(employee.getEmail());
            employeeRepository.save(employee2);
            return new ResponseEntity<>("employee update ",HttpStatus.OK);
        }
        return new ResponseEntity<>("employee not update",HttpStatus.BAD_REQUEST);
    }



    public Optional<Employee> updateEmployeeByHR(Long id, Employee employeeDetails) {
        Optional<Employee> employeeOptional = getEmployeeById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setJobRole(employeeDetails.getJobRole());
            employee.setSalary(employeeDetails.getSalary());

            return Optional.of(employeeRepository.save(employee));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
