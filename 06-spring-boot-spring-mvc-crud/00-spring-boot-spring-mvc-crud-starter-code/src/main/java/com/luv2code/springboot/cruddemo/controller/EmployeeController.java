package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {

        employeeService.save(employee);

        // use a redirect to prevent duplicate submission
        return "redirect:/employees/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

        // get the employee from the service
        Employee employee = employeeService.findById(id);

        // set the employee in the model
        model.addAttribute("employee", employee);

        // send over to our form
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id, Model model) {

        employeeService.deleteById(id);
        return "redirect:/employees/list";

    }

}
