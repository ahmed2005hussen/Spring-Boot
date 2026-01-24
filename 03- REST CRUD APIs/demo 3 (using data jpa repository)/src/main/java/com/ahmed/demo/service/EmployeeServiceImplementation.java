package com.ahmed.demo.service;

import com.ahmed.demo.dao.EmployeeRepository;
import com.ahmed.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        Employee employee1 = null ;

        if(employee.isPresent()){
            employee1 = employee.get();
        }
        else{
            throw new RuntimeException("not found the employee with id " + id);
        }
        return employee1;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteByID(int id) {
        employeeRepository.deleteById(id);
    }
}
