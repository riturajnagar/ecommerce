package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.Role;
import com.onlineshopping.ecommerce.model.RoleName;

import java.util.List;

public interface RoleService {

    Role findByName(RoleName roleName);

    Role saveRole(Role role);

    List<Role> getAllRoles();
}

