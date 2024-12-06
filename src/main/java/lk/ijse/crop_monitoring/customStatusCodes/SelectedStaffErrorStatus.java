package lk.ijse.crop_monitoring.customStatusCodes;

import lk.ijse.crop_monitoring.dto.StaffStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedStaffErrorStatus implements StaffStatus {
    private int statusCode;
    private String statusMessage;
}