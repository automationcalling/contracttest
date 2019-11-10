package com.examples.springbootstarter.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<EmployeeDetails> getempList() {
        return employeeService.getEmployeeList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public void addEmployee(@RequestBody EmployeeDetails employeeDetails) {
        employeeService.addEmployee(employeeDetails);
    }
}
