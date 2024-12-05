package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.dto.VehicleStatus;
import main.java.lk.ijse.crop_monitoring.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    VehicleStatus getVehicle(String vehicleId);
    void deleteVehicle(String vehicleId);
    void updateVehicle(String vehicleId, VehicleDTO vehicleDTO);
}