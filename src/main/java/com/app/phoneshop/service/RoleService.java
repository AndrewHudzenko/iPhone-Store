package com.app.phoneshop.service;

import com.app.phoneshop.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(Role.RoleName roleName);
}
