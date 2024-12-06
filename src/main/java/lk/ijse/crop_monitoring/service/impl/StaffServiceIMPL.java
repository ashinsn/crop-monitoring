package lk.ijse.crop_monitoring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.crop_monitoring.customStatusCodes.SelectedStaffErrorStatus;
import lk.ijse.crop_monitoring.dao.StaffDAO;
import lk.ijse.crop_monitoring.dto.StaffStatus;
import lk.ijse.crop_monitoring.dto.impl.StaffDTO;
import lk.ijse.crop_monitoring.entity.impl.Staff;
import lk.ijse.crop_monitoring.exception.StaffNotFoundException;
import lk.ijse.crop_monitoring.service.StaffService;
import lk.ijse.crop_monitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StaffServiceIMPL implements StaffService {
    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private Mapping staffMapping;

    @Override
    public void saveStaff(StaffDTO staffDTO) {
        Staff saveField = staffDAO.save(staffMapping.toStaffEntity(staffDTO));
        if(saveField == null){
            throw new RuntimeException("Staff not saved");
        }
    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return staffMapping.asStaffDTOList(staffDAO.findAll());
    }

    @Override
    public StaffStatus getStaff(String staffId) {
        if(staffDAO.existsById(staffId)){
            var selectedStaff = staffDAO.getReferenceById(staffId);
            return staffMapping.toStaffDTO(selectedStaff);
        }else {
            return new SelectedStaffErrorStatus(404,"Selected staff not found");
        }
    }

    @Override
    public void deleteStaff(String staffId) {
        Optional<Staff> byStaffId = staffDAO.findById(staffId);
        if (!byStaffId.isPresent()) {
            throw new StaffNotFoundException("Staff not found");
        }else {
            staffDAO.deleteById(staffId);
        }
    }

    @Override
    public void updateStaff(String staffId, StaffDTO staffDTO) {

    }
}