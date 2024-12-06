package lk.ijse.crop_monitoring.customStatusCodes;

import lk.ijse.crop_monitoring.dto.EquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedEquipmentErrorStatus implements EquipmentStatus {
    private int statusCode;
    private String statusMessage;
}