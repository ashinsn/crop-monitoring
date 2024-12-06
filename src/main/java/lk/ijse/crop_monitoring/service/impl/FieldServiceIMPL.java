package lk.ijse.crop_monitoring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.crop_monitoring.customStatusCodes.SelectedFieldErrorStatus;
import lk.ijse.crop_monitoring.dto.FieldStatus;
import lk.ijse.crop_monitoring.DataPersistException;
import lk.ijse.crop_monitoring.dto.impl.FieldDTO;
import lk.ijse.crop_monitoring.entity.impl.Field;
import lk.ijse.crop_monitoring.dao.FieldDAO;
import lk.ijse.crop_monitoring.exception.FieldNotFoundException;
import lk.ijse.crop_monitoring.service.FieldService;
import lk.ijse.crop_monitoring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldServiceIMPL implements FieldService {
    @Autowired
    private FieldDAO fieldDao;
    @Autowired
    private Mapping fieldMapping;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        Field savedField = fieldDao.save(fieldMapping.toFieldEntity(fieldDTO));
        if(savedField == null){
            throw new DataPersistException("Field not saved");
        }
    }

    @Override
    public List<FieldDTO> getAllFields() {
        return fieldMapping.asFieldDTOList( fieldDao.findAll());
    }

    @Override
    public FieldStatus getField(String fieldId) {
        if(fieldDao.existsById(fieldId)){
            var selectedField = fieldDao.getReferenceById(fieldId);
            return fieldMapping.toFieldDTO(selectedField);
        }else {
            return new SelectedFieldErrorStatus(404,"Selected field not found");
        }
    }

    @Override
    public void deleteField(String fieldId) {
        Optional<Field> foundField = fieldDao.findById(fieldId);
        if (!foundField.isPresent()) {
            throw new FieldNotFoundException("Field not found");
        }else {
            fieldDao.deleteById(fieldId);
        }
    }

    @Override
    public void updateField(String fieldId, FieldDTO fieldDTO) {

    }
}
