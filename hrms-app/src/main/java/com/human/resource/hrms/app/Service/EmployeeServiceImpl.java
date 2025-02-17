package com.human.resource.hrms.app.Service;

import com.human.resource.hrms.app.Dto.EmailDetails;
import com.human.resource.hrms.app.Dto.EmployeeDto;
import com.human.resource.hrms.app.Enums.Gender;
import com.human.resource.hrms.app.Model.ContactInfo;
import com.human.resource.hrms.app.Model.Employee;
import com.human.resource.hrms.app.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    EmployeeRepo repo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;
    @Override
    public ResponseEntity<String> RegisterEmployee(EmployeeDto employeeDto)
    {

        //checking email id number if already registered
        Optional<Employee>optionalEmployee=repo.findByIdNumber(employeeDto.getIdNumber());
        if(optionalEmployee.isPresent())
        {
            return  ResponseEntity.badRequest().body("Email already exists");
        }
        else {
            //new employee registration
            Employee newEmployee= Employee.builder()
                    .fullName(employeeDto.getFullName())
                    .password(passwordEncoder.encode(employeeDto.getPassword()))
                    .department(employeeDto.getDepartment())
                    .designation(employeeDto.getDesignation())
                    .joiningDate(employeeDto.getJoiningDate())
                    .birthDate(employeeDto.getBirthDate())
                    .idNumber(employeeDto.getIdNumber())
                    .employmentType(employeeDto.getEmploymentType())
                    .workLocation(employeeDto.getWorkLocation())
                    .gender(employeeDto.getGender()==null?Gender.OTHER:employeeDto.getGender())
                    .build();
            ContactInfo contactInfo= ContactInfo.builder()
                    .email(employeeDto.getEmail())
                    .address(employeeDto.getAddress())
                    .phoneNumber(employeeDto.getPhoneNumber())
                    .employee(newEmployee)
                    .build();
            newEmployee.getContactInfo().add(contactInfo);

            Employee savedEmployee=repo.save(newEmployee);        // saving new employee

            EmailDetails emailDetails= EmailDetails.builder()     //sending email alert
                    .recipient(employeeDto.getEmail())
                    .subject("The registration was successful")
                    .body("Congratulations" + " " + employeeDto.getFullName()+"\n"+"Your account at Kim Software Company Limited has been created successfully"                           )
                    .build();
            emailService.sendEmail(emailDetails);
            return ResponseEntity.ok("Employee registered successfully");
        }    }
    @Override
    public ResponseEntity<String> UpdateEmployee(EmployeeDto employeeDto)
    {
        Optional<Employee>optionalEmployee=repo.findByIdNumber(employeeDto.getIdNumber());
        if(optionalEmployee.isPresent())
        {
           Employee updateDetails= optionalEmployee.get();
           if (employeeDto.getFullName()!=null)
           { updateDetails.setFullName(employeeDto.getFullName());}
           if (employeeDto.getPassword()!=null)
           {updateDetails.setDepartment(employeeDto.getDepartment());}
           if (employeeDto.getDepartment()!=null)
           {updateDetails.setDepartment(employeeDto.getDepartment());}
           if (employeeDto.getDesignation()!=null)
           {updateDetails.setDesignation(employeeDto.getDesignation());}
           if (employeeDto.getJoiningDate()!=null)
           {updateDetails.setJoiningDate(employeeDto.getJoiningDate());}
           if (employeeDto.getBirthDate()!=null)
           {updateDetails.setBirthDate(employeeDto.getBirthDate());}
           if (employeeDto.getIdNumber()!=null)
           {updateDetails.setIdNumber(employeeDto.getIdNumber());}
           if (employeeDto.getEmploymentType()!=null)
           {updateDetails.setEmploymentType(employeeDto.getEmploymentType());}
           if (employeeDto.getWorkLocation()!=null)
           {updateDetails.setWorkLocation(employeeDto.getWorkLocation());}
           if (employeeDto.getGender()!=null)
           {updateDetails.setGender(employeeDto.getGender());}
           if (employeeDto.getContactInfo()!=null&& !employeeDto.getContactInfo().isEmpty())
           { ContactInfo contactInfo=employeeDto.getContactInfo().get(0);
              if (contactInfo.getAddress()!=null) {contactInfo.setAddress(employeeDto.getAddress());}
              if (contactInfo.getPhoneNumber()!=null) {contactInfo.setPhoneNumber(employeeDto.getPhoneNumber());}
              if (contactInfo.getEmail()!=null) {contactInfo.setEmail(employeeDto.getEmail());}
              updateDetails.getContactInfo().add(contactInfo);}
           Employee updatedEmployee=repo.save(updateDetails);

           EmailDetails message= EmailDetails.builder()
                   .recipient(employeeDto.getEmail())
                   .subject("Details updated successfully")
                   .body("Congratulations" + " " + employeeDto.getFullName()+"\n"+"Your account  details were updated successfully"                           )
                   .build();
           emailService.sendEmail(message);
            System.out.println("Email sent to: " + employeeDto.getEmail());
        }
        return ResponseEntity.ok("Employee updated successfully");
            }
@Transactional
    @Override
    public ResponseEntity<String> DeleteEmployee(String idNumber) {

        Optional<Employee>optionalEmployee=repo.findByIdNumber(idNumber);
        if (optionalEmployee.isEmpty())
        {
            return ResponseEntity.badRequest().body("Employee not found");
        }
        else if (optionalEmployee.isPresent())
        {
            repo.deleteByIdNumber(idNumber);
        }
        return ResponseEntity.ok("Employee deleted successfully");
    }
    @Override
    public ResponseEntity<String> GetAllEmployees()
    {
        List<Employee> employeeList=repo.findAll();
        return ResponseEntity.ok(employeeList.toString());
    }
    }
