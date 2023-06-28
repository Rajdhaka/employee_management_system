package com.geekster.employeeManagementSystem.repositories;

import com.geekster.employeeManagementSystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee,Integer>  {

    Employee findFirstByEmployeeEmailId(String employeeEmailId);
}
