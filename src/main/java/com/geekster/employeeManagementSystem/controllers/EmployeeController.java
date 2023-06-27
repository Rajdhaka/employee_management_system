package com.geekster.employeeManagementSystem.controllers;

import com.geekster.employeeManagementSystem.dto.SignInInput;
import com.geekster.employeeManagementSystem.dto.SignInOutput;
import com.geekster.employeeManagementSystem.dto.SignUpOutput;
import com.geekster.employeeManagementSystem.models.Employee;
import com.geekster.employeeManagementSystem.services.EmployeeService;
import com.geekster.employeeManagementSystem.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    TokenService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody Employee signUpDto){
        signUpDto.setEmployeeSalary(-1);
        signUpDto.setEmployeeJobRole("");
        return employeeService.signUp(signUpDto);
    }


    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){

        return employeeService.signIn(signInDto);
    }


    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String employeeEmailId , @RequestParam String token){
        HttpStatus status;
        String msg=null;

        if(authService.authenticate(employeeEmailId,token))
        {
            authService.deleteToken(token);
            msg = "Sign-out Successful";
            status = HttpStatus.OK;

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId,employee);
    }


}
