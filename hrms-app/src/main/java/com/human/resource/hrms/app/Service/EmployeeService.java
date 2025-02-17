package com.human.resource.hrms.app.Service;

import com.human.resource.hrms.app.Dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<String> RegisterEmployee(EmployeeDto employeeDto);
    ResponseEntity<String> UpdateEmployee(EmployeeDto employeeDto);
    ResponseEntity<String> DeleteEmployee(String idNumber);
    ResponseEntity<String> GetAllEmployees();
    // ResponseEntity<String> GetEmployeeByIdNumber(String idNumber);
//    ResponseEntity<String> GetEmployeeByEmail(String email);
//    ResponseEntity<String> GetEmployeeByDepartment(String department);
//    ResponseEntity<String> GetEmployeeByDesignation(String designation);
//    ResponseEntity<String> GetEmployeeByEmploymentType(String employmentType);
//    ResponseEntity<String> GetEmployeeByWorkLocation(String workLocation);
//    ResponseEntity<String> GetEmployeeByGender(String gender);
//    ResponseEntity<String> GetEmployeeByJoiningDate(String joiningDate);
//    ResponseEntity<String> GetEmployeeByBirthDate(String birthDate);
//    ResponseEntity<String> GetEmployeeByFullName(String fullName);
//    ResponseEntity<String> GetEmployeeByPhoneNumber(String phoneNumber);
//    ResponseEntity<String> GetEmployeeByAddress(String address);



}
