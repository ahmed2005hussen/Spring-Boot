package com.ahmed.demo.dao;

import com.ahmed.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteByID(int id);


}
