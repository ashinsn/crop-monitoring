package main.java.lk.ijse.crop_monitoring.customStatusCodes;

import main.java.lk.ijse.crop_monitoring.dto.CropStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCropErrorStatus implements CropStatus {
    private int statusCode;
    private String statusMessage;
}