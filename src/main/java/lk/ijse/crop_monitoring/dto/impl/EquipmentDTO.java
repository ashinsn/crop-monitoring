package main.java.lk.ijse.crop_monitoring.dto.impl;

import jakarta.persistence.*;
import main.java.lk.ijse.crop_monitoring.dto.EquipmentStatus;
import main.java.lk.ijse.crop_monitoring.entity.SuperEntity;
import main.java.lk.ijse.crop_monitoring.entity.impl.Field;
import main.java.lk.ijse.crop_monitoring.entity.impl.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Equipment")
public class EquipmentDTO implements EquipmentStatus {
    @Id
    private String equipmentId;
    private String equipmentName;
    private String equipmentType;
    private String equipmentStatus;
    private String staffId;
    private String fieldCode;
}
