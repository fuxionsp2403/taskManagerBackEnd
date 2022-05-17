package com.max.taskmanagermax_api.utility;

import com.max.taskmanagermax_api.entity.Role;
import com.max.taskmanagermax_api.enums.RoleName;
import com.max.taskmanagermax_api.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateRoles implements CommandLineRunner {
    
    private final RoleService roleService;
    
    public CreateRoles(RoleService roleService) {
        this.roleService = roleService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        if (roleService.getByRoleName(RoleName.ROLE_ADMIN).isEmpty() && roleService.getByRoleName(RoleName.ROLE_USER).isEmpty()) {
            Role adminRole = new Role(RoleName.ROLE_ADMIN);
            Role userRole = new Role(RoleName.ROLE_USER);
            roleService.save(adminRole);
            roleService.save(userRole);
        } else {
            log.error("Roles already exist");
            
        }
    }
    
}
