package com.app.phoneshop.service.impl;

import com.app.phoneshop.model.Role;
import com.app.phoneshop.repository.RoleRepository;
import com.app.phoneshop.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(Role.RoleName roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }
}
