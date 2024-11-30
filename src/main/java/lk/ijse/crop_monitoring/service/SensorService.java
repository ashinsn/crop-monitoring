package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.entity.Sensor;

import java.util.List;

public interface SensorService {
    Sensor saveSensor(Sensor sensor);
    List<Sensor> getSensorsByFarmId(Long farmId);
}