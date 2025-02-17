package com.human.resource.hrms.app.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactInfo", schema = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employee") // exclude employee to prevent recursion
public class ContactInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactInfoId;
    private String email;
    private String phoneNumber;
    private String address;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
