package main.java.lk.ijse.crop_monitoring.customStatusCodes;

import main.java.lk.ijse.crop_monitoring.dto.FieldStatus;
import main.java.lk.ijse.crop_monitoring.dto.LogStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedLogErrorStatus implements LogStatus {
    private int statusCode;
    private String statusMessage;
}