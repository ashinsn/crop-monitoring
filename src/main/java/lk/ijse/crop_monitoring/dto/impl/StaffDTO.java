package main.java.lk.ijse.crop_monitoring.dto.impl;

import main.java.lk.ijse.crop_monitoring.dto.StaffStatus;
import main.java.lk.ijse.crop_monitoring.entity.Gender;
import main.java.lk.ijse.crop_monitoring.entity.Role;
import main.java.lk.ijse.crop_monitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements StaffStatus {
    private String staffId;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private String joinedDate;
    private String dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Role role;
    private String fieldCode;
}