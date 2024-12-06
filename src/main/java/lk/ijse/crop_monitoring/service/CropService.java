package lk.ijse.crop_monitoring.service;

import lk.ijse.crop_monitoring.dto.CropStatus;
import lk.ijse.crop_monitoring.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrops();
    CropStatus getCrop(String cropId);
    void deleteCrop(String cropId);
    void updateCrop(String cropId, CropDTO cropDTO);
}