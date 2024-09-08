package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.exceptions.EntityNotFoundException;
import com.onlineshopping.ecommerce.model.Role;
import com.onlineshopping.ecommerce.model.RoleName;
import com.onlineshopping.ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(RoleName roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with name: " + roleName));
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
