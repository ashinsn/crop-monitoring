package main.java.lk.ijse.crop_monitoring.util;

import main.java.lk.ijse.crop_monitoring.dto.impl.*;
import main.java.lk.ijse.crop_monitoring.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    public Field toFieldEntity(FieldDTO fieldDTO) {
        return modelMapper.map(fieldDTO, Field.class);
    }
    public FieldDTO toFieldDTO(Field fieldEntity) {
        return modelMapper.map(fieldEntity, FieldDTO.class);
    }
    public List<FieldDTO> asFieldDTOList(List<Field> fieldEntities) {
        return modelMapper.map(fieldEntities, new TypeToken<List<FieldDTO>>() {}.getType());
    }

    public Crop toCropEntity(CropDTO cropDTO) {
        return modelMapper.map(cropDTO, Crop.class);
    }
    public CropDTO toCropDTO(Crop cropEntity) {
        return modelMapper.map(cropEntity, CropDTO.class);
    }
    public List<CropDTO> asCropDTOList(List<Crop> cropEntities) {
        return modelMapper.map(cropEntities, new TypeToken<List<CropDTO>>() {}.getType());
    }

    public Staff toStaffEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, Staff.class);
    }
    public StaffDTO toStaffDTO(Staff staffEntity) {
        return modelMapper.map(staffEntity, StaffDTO.class);
    }
    public List<StaffDTO> asStaffDTOList(List<Staff> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>() {}.getType());
    }

    public Vehicle toVehicleEntity(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }
    public VehicleDTO toVehicleDTO(Vehicle vehicleEntity) {
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
    public List<VehicleDTO> asVehicleDTOList(List<Vehicle> vehicleEntities) {
        return modelMapper.map(vehicleEntities, new TypeToken<List<VehicleDTO>>() {}.getType());
    }

    public Equipment toEquipmentEntity(EquipmentDTO equipmentDTO) {
        return modelMapper.map(equipmentDTO, Equipment.class);
    }
    public EquipmentDTO toEquipmentDTO(Equipment equipmentEntity) {
        return modelMapper.map(equipmentEntity, EquipmentDTO.class);
    }
    public List<EquipmentDTO> asEquipmentDTOList(List<Equipment> equipmentEntities) {
        return modelMapper.map(equipmentEntities, new TypeToken<List<EquipmentDTO>>() {}.getType());
    }

    public Log toLogEntity(LogDTO logDTO) {
        return modelMapper.map(logDTO, Log.class);
    }
    public LogDTO toLogDTO(Log logEntity) {
        return modelMapper.map(logEntity, LogDTO.class);
    }
    public List<LogDTO> asLogDTOList(List<Log> logEntities) {
        return modelMapper.map(logEntities, new TypeToken<List<LogDTO>>() {}.getType());
    }
}
