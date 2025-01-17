package lk.ijse.crop_monitoring.dao;

import lk.ijse.crop_monitoring.entity.impl.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDAO extends JpaRepository<Crop, String> {

}