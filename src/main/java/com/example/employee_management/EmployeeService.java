package com.example.employee_management;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// The EmployeeService class contains the business logic to manage employees.
@Service // Marks this class as a Spring service component.
public class EmployeeService {

    private final EmployeeRepository employeeRepository; // The repository that handles data storage.

    // Constructor to inject the EmployeeRepository dependency
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Method to create a new employee
    public String createEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee); // Saves the employee through the repository.
    }

    // Method to retrieve an employee by their ID
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id); // Retrieves employee by ID from the repository.
    }

    // Method to retrieve employees with optional filtering by name and salary range
    public List<Employee> getEmployees(String name, Double fromSalary, Double toSalary) {
        List<Employee> employees = employeeRepository.getAllEmployees(); // Get all employees from the repository.

        // Filter by name if provided (either first name or last name contains the search text)
        if (name != null && !name.isEmpty()) {
            employees = employees.stream()
                    .filter(e -> e.getFirstName().contains(name) || e.getLastName().contains(name))
                    .collect(Collectors.toList());
        }

        // Filter by fromSalary if provided (retrieve employees with salary >= fromSalary)
        if (fromSalary != null) {
            employees = employees.stream()
                    .filter(e -> e.getSalary() >= fromSalary)
                    .collect(Collectors.toList());
        }

        // Filter by toSalary if provided (retrieve employees with salary <= toSalary)
        if (toSalary != null) {
            employees = employees.stream()
                    .filter(e -> e.getSalary() <= toSalary)
                    .collect(Collectors.toList());
        }

        return employees; // Return the filtered list of employees.
    }
}