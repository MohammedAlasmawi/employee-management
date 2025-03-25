package com.example.employee_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// The EmployeeController class handles the HTTP requests related to employee operations.
@RestController
@RequestMapping("/employees") // The root URL for all employee-related endpoints.
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; // The service class responsible for the business logic.

    // Endpoint to create a new employee (POST request)
    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee); // Delegates to the service to save the employee.
    }

    // Endpoint to get an employee by their ID (GET request)
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id); // Delegates to the service to retrieve the employee.
    }

    // Endpoint to get employees with filtering options (GET request)
    @GetMapping
    public List<Employee> getEmployees(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) Double fromSalary,
                                       @RequestParam(required = false) Double toSalary) {
        // Delegates to the service to get a list of employees based on the provided filters.
        return employeeService.getEmployees(name, fromSalary, toSalary);
    }
}
