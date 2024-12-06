package lk.ijse.crop_monitoring.dao;

import lk.ijse.crop_monitoring.entity.impl.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDAO extends JpaRepository<Staff, String> {

}
