package main.java.lk.ijse.crop_monitoring.repository;


import main.java.lk.ijse.crop_monitoring.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findByOwnerId(Long ownerId); // Example of a custom query
}