package main.java.lk.ijse.crop_monitoring.repository;

import com.crop_monitoring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
