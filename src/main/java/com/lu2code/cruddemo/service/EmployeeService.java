package com.lu2code.cruddemo.service;

import com.lu2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteEmployee(int theId);
}
