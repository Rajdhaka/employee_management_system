package com.geekster.employeeManagementSystem.services;

import com.geekster.employeeManagementSystem.models.Employee;
import com.geekster.employeeManagementSystem.models.HR;
import com.geekster.employeeManagementSystem.repositories.IEmployeeDao;
import com.geekster.employeeManagementSystem.repositories.IHRDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class HRService {
    IHRDao hrDao;
    IEmployeeDao employeeDao;


    public ResponseEntity<String> addHR(HR hr) {
        List<HR> allHR =  hrDao.findAll();
        if(allHR ==null){
            hrDao.save(hr);
            return new ResponseEntity<String>("HR Successfully Added !!", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("HR already exist",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateEmployeeDetails(int employeeId, Employee employee) {
        employeeDao.save(employee);
        return new ResponseEntity<String>("Employee updated successfully",HttpStatus.CREATED);
    }
}
