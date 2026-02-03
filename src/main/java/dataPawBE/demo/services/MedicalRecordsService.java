package dataPawBE.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import dataPawBE.demo.models.medicalRecords;
import dataPawBE.demo.repository.IMedicalRecordsRepository;

@Service
public class MedicalRecordsService {
    @Autowired
    private IMedicalRecordsRepository medicalRecordsRepository;

    // Guardar un registro médico
    public medicalRecords saveMedicalRecords(medicalRecords dataMedicalRecords) {
        if (dataMedicalRecords.getClinic_name() == null || dataMedicalRecords.getClinic_name().length() < 7) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "The name does not meet the parameters");
        }
        if (dataMedicalRecords.getPet() == null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Error: debe seleccionar una mascota");
        }
        return this.medicalRecordsRepository.save(dataMedicalRecords);
    }

    // Obtener todos los registros médicos
    public List<medicalRecords> getAllMedicalRecords() {
        return this.medicalRecordsRepository.findAll();
    }

    // Obtener un registro médico por ID
    public medicalRecords getMedicalRecordById(Integer id) {
        Optional<medicalRecords> medicalRecord = this.medicalRecordsRepository.findById(id);
        if (!medicalRecord.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No existe un registro médico con ese ID");
        }
        return medicalRecord.get();
    }
}
