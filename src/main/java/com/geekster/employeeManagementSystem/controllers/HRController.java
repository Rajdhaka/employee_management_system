package com.geekster.employeeManagementSystem.controllers;

import com.geekster.employeeManagementSystem.models.Employee;
import com.geekster.employeeManagementSystem.models.HR;
import com.geekster.employeeManagementSystem.services.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class HRController {

    @Autowired
    HRService hrService;


    @PostMapping(value = "/")
    public ResponseEntity<String> addHR(@RequestBody HR hr) {

        return hrService.addHR(hr);

    }
    @PutMapping(value = "hrId/employeeId")
    public ResponseEntity<String>updateEmployeeDetails(@PathVariable long hrId, @PathVariable int employeeId, @RequestBody Employee employee){
        return hrService.updateEmployeeDetails(hrId,employeeId,employee);
    }
    @DeleteMapping(value = "hrId/employeeId")
    public ResponseEntity<String>deleteEmployee(@PathVariable long hrId, @PathVariable int employeeId){
        return hrService.deleteEmployee(hrId,employeeId);
    }
}

