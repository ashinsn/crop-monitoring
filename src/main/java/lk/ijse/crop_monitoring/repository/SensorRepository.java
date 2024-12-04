package main.java.lk.ijse.crop_monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByFarmId(Long farmId); // Example of a custom query
}
