package com.human.resource.hrms.app.Dto;

import com.human.resource.hrms.app.Enums.Gender;
import com.human.resource.hrms.app.Model.ContactInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String fullName;
    private String idNumber;
    private String employmentType;
    private Gender gender;
    private String workLocation;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String department;
    private String designation;
    private LocalDate joiningDate;
    private LocalDate birthDate;

    private List<ContactInfo> contactInfo = new ArrayList<>();
}
