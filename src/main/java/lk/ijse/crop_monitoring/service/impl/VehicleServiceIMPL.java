package lk.ijse.crop_monitoring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.crop_monitoring.customStatusCodes.SelectedVehicleErrorStatus;
import lk.ijse.crop_monitoring.dao.VehicleDAO;
import lk.ijse.crop_monitoring.dto.VehicleStatus;
import lk.ijse.crop_monitoring.dto.impl.VehicleDTO;
import lk.ijse.crop_monitoring.entity.impl.Vehicle;
import lk.ijse.crop_monitoring.exception.VehicleNotFoundException;
import lk.ijse.crop_monitoring.service.VehicleService;
import lk.ijse.crop_monitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleService {
    @Autowired
    private VehicleDAO vehicleDAO;

    @Autowired
    private Mapping vehicleMapping;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle saveField = vehicleDAO.save(vehicleMapping.toVehicleEntity(vehicleDTO));
        if(saveField == null){
            throw new RuntimeException("Vehicle not saved");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleMapping.asVehicleDTOList(vehicleDAO.findAll());
    }

    @Override
    public VehicleStatus getVehicle(String vehicleId) {
        if(vehicleDAO.existsById(vehicleId)){
            var selectedVehicle = vehicleDAO.getReferenceById(vehicleId);
            return vehicleMapping.toVehicleDTO(selectedVehicle);
        }else {
            return new SelectedVehicleErrorStatus(404,"Selected vehicle not found");
        }
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        Optional<Vehicle> byVehicleId = vehicleDAO.findById(vehicleId);
        if (!byVehicleId.isPresent()) {
            throw new VehicleNotFoundException("Vehicle not found");
        }else {
            vehicleDAO.deleteById(vehicleId);
        }
    }

    @Override
    public void updateVehicle(String vehicleId, VehicleDTO vehicleDTO) {

    }
}
