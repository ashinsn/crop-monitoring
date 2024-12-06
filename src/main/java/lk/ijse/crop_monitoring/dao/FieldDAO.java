package lk.ijse.crop_monitoring.dao;

import lk.ijse.crop_monitoring.entity.impl.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDAO extends JpaRepository<Field, String> {

}
