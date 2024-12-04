package main.java.lk.ijse.crop_monitoring.controller;

import main.java.lk.ijse.crop_monitoring.DataPersistException;
import main.java.lk.ijse.crop_monitoring.customStatusCodes.SelectedEquipmentErrorStatus;
import main.java.lk.ijse.crop_monitoring.dto.EquipmentStatus;
import main.java.lk.ijse.crop_monitoring.dto.impl.EquipmentDTO;
import main.java.lk.ijse.crop_monitoring.exception.EquipmentNotFoundException;
import main.java.lk.ijse.crop_monitoring.service.EquipmentService;
import main.java.lk.ijse.crop_monitoring.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentController {
    static Logger logger =  LoggerFactory.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(
            @RequestPart ("equipmentId") String equipmentId,
            @RequestPart ("equipmentName") String equipmentName,
            @RequestPart ("equipmentType") String equipmentType,
            @RequestPart ("equipmentStatus") String equipmentStatus,
            @RequestPart ("staffId") String staffId,
            @RequestPart ("fieldCode") String fieldCode
    ){
        try {
            if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
                logger.info("Equipment ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.equipmentNameMatcher(equipmentName)) {
                logger.info("Equipment name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.equipmentTypeMatcher(equipmentType)) {
                logger.info("Equipment type is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.equipmentStatusMatcher(equipmentStatus)) {
                logger.info("Equipment status is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.staffIdMatcher(staffId)) {
                logger.info("Staff ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.fieldCodeMatcher(fieldCode)) {
                logger.info("Field code is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            EquipmentDTO equipmentDTO = new EquipmentDTO();
            equipmentDTO.setEquipmentId(equipmentId);
            equipmentDTO.setEquipmentName(equipmentName);
            equipmentDTO.setEquipmentType(equipmentType);
            equipmentDTO.setEquipmentStatus(equipmentStatus);
            equipmentDTO.setStaffId(staffId);
            equipmentDTO.setFieldCode(fieldCode);

            equipmentService.saveEquipment(equipmentDTO);
            logger.info("Equipment saved successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{equipmentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipmentStatus getSelectedEquipment(@PathVariable ("equipmentId") String equipmentId) {
        if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
            logger.error("Equipment ID is not valid");
            return new SelectedEquipmentErrorStatus(1, "Equipment ID is not valid");
        }
        logger.info("Equipment fetched");
        return equipmentService.getEquipment(equipmentId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDTO> getAllEquipments() {
        logger.info("All equipments fetched");
        return equipmentService.getAllEquipments();
    }

    @DeleteMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable ("equipmentId") String equipmentId){
        try {
            if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
                logger.info("Equipment ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logger.info("Equipment deleted");
            equipmentService.deleteEquipment(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EquipmentNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEquipment(
            @RequestPart ("equipmentId") String equipmentId,
            @RequestPart ("equipmentName") String equipmentName,
            @RequestPart ("equipmentType") String equipmentType,
            @RequestPart ("equipmentStatus") String equipmentStatus,
            @RequestPart ("staffId") String staffId,
            @RequestPart ("fieldCode") String fieldCode
    ) {
        try {
            if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
                logger.info("Equipment ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.equipmentNameMatcher(equipmentName)) {
                logger.info("Equipment name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.equipmentTypeMatcher(equipmentType)) {
                logger.info("Equipment type is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.equipmentStatusMatcher(equipmentStatus)) {
                logger.info("Equipment status is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.staffIdMatcher(staffId)) {
                logger.info("Staff ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.fieldCodeMatcher(fieldCode)) {
                logger.info("Field code is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            EquipmentDTO equipmentDTO = new EquipmentDTO();
            equipmentDTO.setEquipmentId(equipmentId);
            equipmentDTO.setEquipmentName(equipmentName);
            equipmentDTO.setEquipmentType(equipmentType);
            equipmentDTO.setEquipmentStatus(equipmentStatus);
            equipmentDTO.setStaffId(staffId);
            equipmentDTO.setFieldCode(fieldCode);
            logger.info("Equipment updated successfully");
            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
