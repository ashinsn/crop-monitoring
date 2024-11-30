package main.java.lk.ijse.crop_monitoring.controller;

import main.java.lk.ijse.crop_monitoring.entity.Sensor;
import main.java.lk.ijse.crop_monitoring.service.SensorService;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorService.saveSensor(sensor);
    }

    @GetMapping("/farm/{farmId}")
    public List<Sensor> getSensorsByFarmId(@PathVariable Long farmId) {
        return sensorService.getSensorsByFarmId(farmId);
    }
}