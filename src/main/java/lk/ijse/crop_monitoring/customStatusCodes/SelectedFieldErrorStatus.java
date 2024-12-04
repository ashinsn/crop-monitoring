package main.java.lk.ijse.crop_monitoring.customStatusCodes;

import main.java.lk.ijse.crop_monitoring.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedFieldErrorStatus implements FieldStatus {
    private int statusCode;
    private String statusMessage;
}