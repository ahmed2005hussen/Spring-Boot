package com.ahmed.demo.dao;

import com.ahmed.demo.entity.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimplementation implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    EmployeeDAOimplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class , id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        Employee theEmployee = entityManager.merge(employee);

        return theEmployee;
    }

    @Override
    public void deleteByID(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
