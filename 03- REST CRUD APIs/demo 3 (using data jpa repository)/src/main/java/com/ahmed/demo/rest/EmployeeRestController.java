package com.ahmed.demo.rest;

import com.ahmed.demo.entity.Employee;
import com.ahmed.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService ,  JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {

        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        return employee ;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {

        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@RequestBody Map<String , Object> patchPayload , @PathVariable int id){

     Employee employee = employeeService.findById(id);

     if(employee == null){
         throw new RuntimeException("Employee with id " + id + " not found");
     }

     if(patchPayload.containsKey("id")){
         throw new RuntimeException("Employee id is not required in PATCH request ");
     }

     Employee patchEmployee = jsonMapper.updateValue(employee, patchPayload);

     return employeeService.save(patchEmployee);
    }
    
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employeeToDelete = employeeService.findById(id);

        if(employeeToDelete == null){
            throw new RuntimeException("Employee with id " + id + " not found");
        }

        employeeService.deleteByID(id);

        return "Employee with id " + id + " deleted";
    }
}
