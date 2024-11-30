package main.java.lk.ijse.crop_monitoring.service.impl;

import main.java.lk.ijse.crop_monitoring.entity.Sensor;
import main.java.lk.ijse.crop_monitoring.repository.SensorRepository;
import main.java.lk.ijse.crop_monitoring.service.SensorService;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor saveSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public List<Sensor> getSensorsByFarmId(Long farmId) {
        return sensorRepository.findByFarmId(farmId);
    }
}