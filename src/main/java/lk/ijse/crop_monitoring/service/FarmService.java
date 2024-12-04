package main.java.lk.ijse.crop_monitoring.service;

import java.util.List;

public interface FarmService {
    Farm saveFarm(Farm farm);
    List<Farm> getFarmsByOwnerId(Long ownerId);
}