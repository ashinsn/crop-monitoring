package main.java.lk.ijse.crop_monitoring.controller;

import main.java.lk.ijse.crop_monitoring.DataPersistException;
import main.java.lk.ijse.crop_monitoring.customStatusCodes.SelectedCropErrorStatus;
import main.java.lk.ijse.crop_monitoring.dto.CropStatus;
import main.java.lk.ijse.crop_monitoring.dto.impl.CropDTO;
import main.java.lk.ijse.crop_monitoring.exception.CropNotFoundException;
import main.java.lk.ijse.crop_monitoring.service.CropService;
import main.java.lk.ijse.crop_monitoring.util.AppUtil;
import main.java.lk.ijse.crop_monitoring.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/crop")
public class CropController {

    static Logger logger =  LoggerFactory.getLogger(CropController.class);

    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart ("cropCode") String cropCode,
            @RequestPart ("cropName") String cropName,
            @RequestPart ("cropScientificName") String cropScientificName,
            @RequestPart ("cropImage") MultipartFile cropImage,
            @RequestPart ("cropCategory") String cropCategory,
            @RequestPart ("cropSeason") String cropSeason,
            @RequestPart ("fieldCode") String fieldCode
    ){
        String base64CropImage = "";
        try{
            byte[] imageBytes = cropImage.getBytes();
            base64CropImage = AppUtil.picToBase64(imageBytes);

            if (!RegexProcess.cropIdMatcher(cropCode)) {
                logger.info("Crop ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.cropNameMatcher(cropName)) {
                logger.info("Crop name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.cropScientificNameMatcher(cropScientificName)) {
                logger.info("Crop scientific name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.cropCategoryMatcher(cropCategory)) {
                logger.info("Crop category is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            CropDTO cropDTO = new CropDTO();
            cropDTO.setCode(cropCode);
            cropDTO.setCommonName(cropName);
            cropDTO.setScientificName(cropScientificName);
            cropDTO.setCategory(cropCategory);
            cropDTO.setSeason(cropSeason);
            cropDTO.setFieldCode(fieldCode);
            cropDTO.setImage(base64CropImage);
            cropService.saveCrop(cropDTO);
            logger.info("Crop saved");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.info("Data persist error");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{cropId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CropStatus getSelectedCrop(@PathVariable ("cropId") String cropId) {
        if (!RegexProcess.cropIdMatcher(cropId)) {
            logger.info("Crop ID is not valid");
            return new SelectedCropErrorStatus(1, "Crop ID is not valid");
        }
        logger.info("Crop fetched");
        return cropService.getCrop(cropId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDTO> getAllCrops() {
        logger.info("All crops fetched");
        return cropService.getAllCrops();
    }

    @DeleteMapping(value = "/{cropId}")
    public ResponseEntity<Void> deleteCrop(@PathVariable ("cropId") String cropId){
        try {
            if (!RegexProcess.cropIdMatcher(cropId)) {
                logger.info("Crop ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cropService.deleteCrop(cropId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CropNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCrop(
            @RequestPart ("cropCode") String cropCode,
            @RequestPart ("cropName") String cropName,
            @RequestPart ("cropScientificName") String cropScientificName,
            @RequestPart ("cropImage") MultipartFile cropImage,
            @RequestPart ("cropCategory") String cropCategory,
            @RequestPart ("cropSeason") String cropSeason,
            @RequestPart ("fieldCode") String fieldCode
    ){
        String base64CropImage = "";
        try{
            byte[] imageBytes = cropImage.getBytes();
            base64CropImage = AppUtil.picToBase64(imageBytes);

            if (RegexProcess.cropIdMatcher(cropCode)) {
                logger.info("Crop ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.cropNameMatcher(cropName)) {
                logger.info("Crop name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.cropScientificNameMatcher(cropScientificName)) {
                logger.info("Crop scientific name is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (!RegexProcess.cropCategoryMatcher(cropCategory)) {
                logger.info("Crop category is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            CropDTO cropDTO = new CropDTO();
            cropDTO.setCode(cropCode);
            cropDTO.setCommonName(cropName);
            cropDTO.setScientificName(cropScientificName);
            cropDTO.setCategory(cropCategory);
            cropDTO.setSeason(cropSeason);
            cropDTO.setFieldCode(fieldCode);
            cropDTO.setImage(base64CropImage);
            cropService.saveCrop(cropDTO);
            logger.info("Crop updated");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
