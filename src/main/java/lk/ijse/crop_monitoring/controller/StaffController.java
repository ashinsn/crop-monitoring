package lk.ijse.crop_monitoring.controller;

import lk.ijse.crop_monitoring.customStatusCodes.SelectedStaffErrorStatus;
import lk.ijse.crop_monitoring.DataPersistException;
import lk.ijse.crop_monitoring.dto.StaffStatus;
import lk.ijse.crop_monitoring.dto.impl.StaffDTO;
import main.java.lk.ijse.crop_monitoring.entity.Gender;
import main.java.lk.ijse.crop_monitoring.entity.Role;
import lk.ijse.crop_monitoring.exception.StaffNotFoundException;
import lk.ijse.crop_monitoring.service.StaffService;
import lk.ijse.crop_monitoring.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
    static Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(
            @RequestPart("staffId") String staffId,
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("designation") String designation,
            @RequestPart("gender") String gender,
            @RequestPart("joinedDate") String joinedDate,
            @RequestPart("dob") String dob,
            @RequestPart("addressLine1") String addressLine1,
            @RequestPart("addressLine2") String addressLine2,
            @RequestPart("addressLine3") String addressLine3,
            @RequestPart("addressLine4") String addressLine4,
            @RequestPart("addressLine5") String addressLine5,
            @RequestPart("contactNo") String contactNo,
            @RequestPart("email") String email,
            @RequestPart("role") String role,
            @RequestPart("fieldCode") String fieldCode
    ) {
        try {
            if (!RegexProcess.staffIdMatcher(staffId)) {
                logger.info("Staff ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffFirstNameMatcher(firstName)){
                logger.info("First name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffLastNameMatcher(lastName)){
                logger.info("Last name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffDesignationMatcher(designation)){
                logger.info("Designation is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffGenderMatcher(gender)){
                logger.info("Gender is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffJoinedDateMatcher(joinedDate)){
                logger.info("Joined date is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffDobMatcher(dob)){
                logger.info("Date of birth is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffAddress2Matcher(addressLine2)) {
                logger.info("Address line 2 is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffAddress3Matcher(addressLine3)) {
                logger.info("Address line 3 is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffAddress4Matcher(addressLine4)) {
                logger.info("Address line 4 is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffAddress5Matcher(addressLine5)) {
                logger.info("Address line 5 is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if(!RegexProcess.staffContactNoMatcher(contactNo)){
                logger.info("Contact number is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.staffEmailMatcher(email)) {
                logger.info("Email is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.staffRoleMatcher(role)) {
                logger.info("Role is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.staffFieldCodeMatcher(fieldCode)) {
                logger.info("Field code is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            StaffDTO staffDTO = new StaffDTO();
            staffDTO.setStaffId(staffId);
            staffDTO.setFirstName(firstName);
            staffDTO.setLastName(lastName);
            staffDTO.setDesignation(designation);
            staffDTO.setGender(Gender.valueOf(gender.toUpperCase())); // Assuming you have a Gender enum.
            staffDTO.setJoinedDate(joinedDate);
            staffDTO.setDob(dob);
            staffDTO.setAddressLine1(addressLine1);
            staffDTO.setAddressLine2(addressLine2);
            staffDTO.setAddressLine3(addressLine3);
            staffDTO.setAddressLine4(addressLine4);
            staffDTO.setAddressLine5(addressLine5);
            staffDTO.setContactNo(contactNo);
            staffDTO.setEmail(email);
            staffDTO.setRole(Role.valueOf(role.toUpperCase()));
            staffDTO.setFieldCode(fieldCode);
            staffService.saveStaff(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffStatus getSelectedStaff(@PathVariable("staffId") String staffId) {
        if (!RegexProcess.staffIdMatcher(staffId)) {
            return new SelectedStaffErrorStatus(1, "Staff ID is not valid");
        }
        return staffService.getStaff(staffId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDTO> getAllStaffs() {
        return staffService.getAllStaffs();
    }

    @DeleteMapping(value = "/{staffId}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("staffId") String staffId) {
        try {
            if (!RegexProcess.staffIdMatcher(staffId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            staffService.deleteStaff(staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}