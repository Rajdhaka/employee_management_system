package com.geekster.employeeManagementSystem.controllers;

import com.geekster.employeeManagementSystem.models.Employee;
import com.geekster.employeeManagementSystem.models.HR;
import com.geekster.employeeManagementSystem.services.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hr")
public class HRController {

    @Autowired
    HRService hrService;


    @PostMapping(value = "/")
    public ResponseEntity<String> addHR(@RequestBody HR hr) {

        return hrService.addHR(hr);

    }
    @PutMapping(value = "/employeeId/employee")
    public ResponseEntity<String>updateEmployeeDetails(@PathVariable int employeeId, @RequestBody Employee employee){
        return hrService.updateEmployeeDetails(employeeId,employee);
    }
}

