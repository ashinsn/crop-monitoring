package main.java.lk.ijse.crop_monitoring.dao;

import main.java.lk.ijse.crop_monitoring.entity.impl.Crop;
import main.java.lk.ijse.crop_monitoring.entity.impl.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDAO extends JpaRepository<Log, String> {

}