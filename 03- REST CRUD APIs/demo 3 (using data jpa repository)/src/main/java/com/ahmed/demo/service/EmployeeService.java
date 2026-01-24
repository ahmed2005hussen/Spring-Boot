package com.ahmed.demo.service;
import com.ahmed.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteByID(int id);
}
