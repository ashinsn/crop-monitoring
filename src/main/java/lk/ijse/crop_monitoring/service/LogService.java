package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.dto.LogStatus;
import main.java.lk.ijse.crop_monitoring.dto.impl.LogDTO;

import java.util.List;

public interface LogService {
    void saveLog(LogDTO logDTO);
    List<LogDTO> getAllLogs();
    LogStatus getLog(String logId);
    void deleteLog(String logId);
    void updateLog(String logId, LogDTO logDTO);
}
