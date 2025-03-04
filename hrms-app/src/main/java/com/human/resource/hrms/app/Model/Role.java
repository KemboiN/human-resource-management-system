package com.human.resource.hrms.app.Model;

import com.human.resource.hrms.app.Enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int id;
    @Enumerated(EnumType.STRING)
    private RoleType name;

}
