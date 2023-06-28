package com.geekster.employeeManagementSystem.repositories;

import com.geekster.employeeManagementSystem.models.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenDao extends JpaRepository<AuthenticationToken , Long> {
    AuthenticationToken findFirstByToken(String token);


}
