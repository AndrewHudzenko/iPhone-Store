package com.app.phoneshop.repository;

import com.app.phoneshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRoleName(Role.RoleName roleName);
}
