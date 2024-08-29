package com.lu2code.cruddemo.dao;

import com.lu2code.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add a method sort by lastName
    public List<Employee> findAllByOrderByLastNameAsc();
}
