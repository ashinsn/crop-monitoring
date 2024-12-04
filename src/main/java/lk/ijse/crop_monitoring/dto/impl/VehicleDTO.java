package main.java.lk.ijse.crop_monitoring.dto.impl;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import main.java.lk.ijse.crop_monitoring.dto.VehicleStatus;
import main.java.lk.ijse.crop_monitoring.entity.impl.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements VehicleStatus {
    private String vehicleCode;
    private String licensePlate;
    private String category;
    private String fuelType;
    private String status;
    private String staffId;
    private String remarks;
}