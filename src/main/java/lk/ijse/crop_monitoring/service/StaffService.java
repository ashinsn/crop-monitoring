package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.dto.StaffStatus;
import main.java.lk.ijse.crop_monitoring.dto.impl.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    List<StaffDTO> getAllStaffs();
    StaffStatus getStaff(String staffId);
    void deleteStaff(String staffId);
    void updateStaff(String staffId, StaffDTO staffDTO);
}
