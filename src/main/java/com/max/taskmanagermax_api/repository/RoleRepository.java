package com.max.taskmanagermax_api.repository;

import com.max.taskmanagermax_api.entity.Role;
import com.max.taskmanagermax_api.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Optional<Role> findByRoleName(RoleName roleName);
}
