package com.geekster.employeeManagementSystem.repositories;

import com.geekster.employeeManagementSystem.models.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHRDao extends JpaRepository<HR,Long> {

}
