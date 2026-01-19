package dataPawBE.demo.services;

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



     public medicalRecords saveMedicalRecords(medicalRecords dataMedicalRecords){

        if(dataMedicalRecords.getClinic_name() == null || dataMedicalRecords.getClinic_name().length() < 7){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "The name does not meet the parameters"
            );
        }

        return this.medicalRecordsRepository.save(dataMedicalRecords);
        
    }
    
}
