package com.max.taskmanagermax_api.service;

import com.max.taskmanagermax_api.entity.Role;
import com.max.taskmanagermax_api.enums.RoleName;
import com.max.taskmanagermax_api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {
    

    private final RoleRepository roleRepository;
    
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    public Optional<Role> getByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
    
    public void save(Role role) {
        roleRepository.save(role);
    }
}
