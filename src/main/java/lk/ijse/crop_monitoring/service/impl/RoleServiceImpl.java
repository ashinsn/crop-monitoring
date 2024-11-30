package main.java.lk.ijse.crop_monitoring.service.impl;


import main.java.lk.ijse.crop_monitoring.repository.RoleRepository;
import main.java.lk.ijse.crop_monitoring.service.RoleService;

import javax.management.relation.Role;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}