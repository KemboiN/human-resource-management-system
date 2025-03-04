package com.human.resource.hrms.app.Model;

import com.human.resource.hrms.app.Enums.EmployeeStatus;
import com.human.resource.hrms.app.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Enumerated(EnumType.STRING)       // Store the enum as a String in database
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employeeRole" , joinColumns = @JoinColumn(name="employeeId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles=new HashSet<>();



}
