package lk.ijse.crop_monitoring.dao;

import lk.ijse.crop_monitoring.entity.impl.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, String> {

}
