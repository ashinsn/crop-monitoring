package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.dto.EquipmentStatus;
import main.java.lk.ijse.crop_monitoring.dto.impl.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);
    List<EquipmentDTO> getAllEquipments();
    EquipmentStatus getEquipment(String equipmentId);
    void deleteEquipment(String equipmentId);
    void updateEquipment(String equipmentId, EquipmentDTO equipmentDTO);
}
