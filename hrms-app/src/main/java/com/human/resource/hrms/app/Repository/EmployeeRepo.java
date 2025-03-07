package com.human.resource.hrms.app.Repository;

import com.human.resource.hrms.app.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee ,Integer >
{

    Optional<Employee>findByIdNumber(String employeeIdNumber);
    Optional<Employee>deleteByIdNumber(String employeeIdNumber);

}
