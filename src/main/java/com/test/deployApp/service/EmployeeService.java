package com.test.deployApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.deployApp.model.Employee;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private int currentId = 100;

    public EmployeeService() {
        // Adding some dummy data to the list
        employeeList.add(new Employee(1, "John Doe", "john.doe@example.com", "Engineering"));
        employeeList.add(new Employee(2, "Jane Smith", "jane.smith@example.com", "Marketing"));
        employeeList.add(new Employee(3, "Alice Johnson", "alice.johnson@example.com", "HR"));
    }
    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(int id) {
        return employeeList.stream().filter(employee -> employee.getId() ==id).findFirst();
    }

    // Create new employee
    public Employee createEmployee(Employee employee) {
        employee.setId(currentId++);
        employeeList.add(employee);
        return employee;
    }

    // Update employee
    public Employee updateEmployee(int id, Employee employee) {
        Optional<Employee> existingEmployee = getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employee.setId(id);
            employeeList.remove(existingEmployee.get());
            employeeList.add(employee);
            return employee;
        }
        return null;
    }

    // Delete employee
    public boolean deleteEmployee(int id) {
        return employeeList.removeIf(employee -> employee.getId() == id);
    }
}
