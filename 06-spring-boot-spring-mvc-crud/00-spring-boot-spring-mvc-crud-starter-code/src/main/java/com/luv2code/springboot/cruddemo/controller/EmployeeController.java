package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees") // Base Mapping for url request
public class EmployeeController {


    private EmployeeService employeeService;

    // Inject the employee service
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // add mapping for the list of employee "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get the employee from the database

        List<Employee> employees = employeeService.findAll();

        // add to the spring model

        model.addAttribute("employees", employees);

        return "list-employees";
    }



}
