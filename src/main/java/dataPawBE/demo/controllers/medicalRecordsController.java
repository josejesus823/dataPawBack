package dataPawBE.demo.controllers;

import dataPawBE.demo.models.medicalRecords;
import dataPawBE.demo.services.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/medicalRecords")
public class medicalRecordsController {
    @Autowired
    MedicalRecordsService medicalRecordsService;

    @PostMapping
     public ResponseEntity <medicalRecords> save(@RequestBody medicalRecords data){
      medicalRecords saveResponseAPI = this.medicalRecordsService.saveMedicalRecords(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };

}
