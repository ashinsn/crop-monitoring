package main.java.lk.ijse.crop_monitoring.entity.impl;

import jakarta.persistence.*;
import main.java.lk.ijse.crop_monitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Equipment")
public class Equipment implements SuperEntity {
    @Id
    private String equipmentId;
    private String equipmentName;
    private String equipmentType;
    private String equipmentStatus;
    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private Field field;
}
