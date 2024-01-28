package com.springdemo.cruddemo.dao;

import com.springdemo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
