package com.example.employee_management;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// The EmployeeRepository class handles the reading and writing of employee data to/from a file.
@Repository // Marks this class as a Spring repository component.
public class EmployeeRepository {

    private static final String FILE_PATH = "src/main/resources/employees.json"; // Path to the JSON file.

    // Method to save an employee into the file
    public String saveEmployee(Employee employee) {
        List<Employee> employees = getAllEmployees(); // Retrieve the existing employees.
        employees.add(employee); // Add the new employee to the list.
        try {
            ObjectMapper mapper = new ObjectMapper(); // Jackson object mapper to convert objects to JSON.
            mapper.writeValue(new File(FILE_PATH), employees); // Write the updated employee list to the file.
        } catch (IOException e) {
            e.printStackTrace(); // Print error if there's an issue writing to the file.
        }
        return "Employee added successfully"; // Return success message.
    }

    // Method to retrieve an employee by ID
    public Optional<Employee> getEmployeeById(String id) {
        List<Employee> employees = getAllEmployees(); // Retrieve all employees.
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst(); // Find employee by ID.
    }

    // Method to retrieve all employees from the file
    public List<Employee> getAllEmployees() {
        try {
            ObjectMapper mapper = new ObjectMapper(); // Jackson object mapper to read JSON.
            // Read the JSON file and map it to a list of Employee objects.
            return mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
        } catch (IOException e) {
            e.printStackTrace(); // Print error if there's an issue reading the file.
            return new ArrayList<>(); // Return an empty list if the file is empty or can't be read.
        }
    }
}