package main.java.lk.ijse.crop_monitoring.dto.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import main.java.lk.ijse.crop_monitoring.dto.LogStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Log")
public class LogDTO implements LogStatus {
    @Id
    private String logCode;
    private String logDate;
    private String details;
    @Column(columnDefinition = "LONGTEXT")
    private String observedImage;
    private String fieldCode;
    private String cropCode;
    private String staffId;
}
