package main.java.lk.ijse.crop_monitoring.controller;

import main.java.lk.ijse.crop_monitoring.entity.Farm;
import main.java.lk.ijse.crop_monitoring.service.FarmService;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping
    public Farm createFarm(@RequestBody Farm farm) {
        return farmService.saveFarm(farm);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Farm> getFarmsByOwnerId(@PathVariable Long ownerId) {
        return farmService.getFarmsByOwnerId(ownerId);
    }
}