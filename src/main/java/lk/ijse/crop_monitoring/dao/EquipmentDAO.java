package lk.ijse.crop_monitoring.dao;

import lk.ijse.crop_monitoring.entity.impl.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDAO extends JpaRepository<Equipment, String> {

}