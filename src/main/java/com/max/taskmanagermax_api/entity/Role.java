package com.max.taskmanagermax_api.entity;

import com.max.taskmanagermax_api.enums.RoleName;
import com.sun.istack.NotNull;
import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "roles")
public class Role {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Enumerated (EnumType.STRING)
    @Column
    private RoleName roleName;
    
    public Role(@NotNull RoleName roleName) {
        this.roleName = roleName;
    }
}
