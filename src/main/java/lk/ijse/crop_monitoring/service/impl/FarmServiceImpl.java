package main.java.lk.ijse.crop_monitoring.service.impl;

import main.java.lk.ijse.crop_monitoring.repository.FarmRepository;
import main.java.lk.ijse.crop_monitoring.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService {
    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public Farm saveFarm(Farm farm) {
        return farmRepository.save(farm);
    }

    @Override
    public List<Farm> getFarmsByOwnerId(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }
}