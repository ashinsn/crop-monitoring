package main.java.lk.ijse.crop_monitoring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
