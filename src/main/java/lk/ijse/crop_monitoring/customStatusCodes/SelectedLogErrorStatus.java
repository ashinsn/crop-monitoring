package lk.ijse.crop_monitoring.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lk.ijse.crop_monitoring.dto.LogStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedLogErrorStatus implements LogStatus {
    private int statusCode;
    private String statusMessage;
}