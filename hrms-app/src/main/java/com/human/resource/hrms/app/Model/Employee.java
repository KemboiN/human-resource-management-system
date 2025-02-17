package com.human.resource.hrms.app.Model;

import com.human.resource.hrms.app.Enums.EmployeeStatus;
import com.human.resource.hrms.app.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contactInfo") // exclude contactInfo to prevent recursion
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String fullName;
    private String idNumber;
    private String employmentType;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String password;
    private String department;
    private String designation;
    private String workLocation;
    private LocalDate joiningDate;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default //ensuring contactInfo is always initialized
    private List<ContactInfo>contactInfo= new ArrayList<>();



}
