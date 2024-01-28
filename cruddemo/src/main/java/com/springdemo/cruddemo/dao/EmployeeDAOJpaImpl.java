package com.springdemo.cruddemo.dao;

import com.springdemo.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    // Setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // Execute query and get result
        List<Employee> employees = theQuery.getResultList();
        //Return the results

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // Get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // Return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // Save the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // Return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // Find the employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // Remove employee
        entityManager.remove(theEmployee);

    }
}
