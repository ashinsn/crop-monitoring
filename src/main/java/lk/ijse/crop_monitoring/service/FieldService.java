package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.dto.FieldStatus;
import main.java.lk.ijse.crop_monitoring.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO noteDTO);
    List<FieldDTO> getAllFields();
    FieldStatus getField(String noteId);
    void deleteField(String noteId);
    void updateField(String noteId, FieldDTO noteDTO);
}
