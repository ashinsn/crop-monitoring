package main.java.lk.ijse.crop_monitoring.service;

import javax.management.relation.Role;

public interface RoleService {
    Role saveRole(Role role);
    Role getRoleByName(String name);
}