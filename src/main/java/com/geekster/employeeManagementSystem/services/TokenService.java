package com.geekster.employeeManagementSystem.services;

import com.geekster.employeeManagementSystem.models.AuthenticationToken;
import com.geekster.employeeManagementSystem.models.Employee;
import com.geekster.employeeManagementSystem.repositories.ITokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    ITokenDao tokenRepo;
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public boolean authenticate(String employeeEmailId, String token) {

        if(token==null && employeeEmailId==null){
            return false;
        }

        AuthenticationToken authToken = tokenRepo.findFirstByToken(token);

        if(authToken==null){
            return false;
        }

        String expectedEmail = authToken.getEmployee().getEmployeeEmailId();


        return expectedEmail.equals(employeeEmailId);
    }


    public void deleteToken(String token) {
        AuthenticationToken token1 = tokenRepo.findFirstByToken(token);

        tokenRepo.deleteById(token1.getTokenId());
    }

    public Employee findUserByToken(String token)
    {
        return tokenRepo.findFirstByToken(token).getEmployee();
    }
}
