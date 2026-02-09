package dataPawBE.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dataPawBE.demo.models.medicalRecords;
import dataPawBE.demo.services.MedicalRecordsService;


@RestController
@RequestMapping("/api/v1/medicalRecords")
public class medicalRecordsController {
    @Autowired
    MedicalRecordsService medicalRecordsService;

     //Entpoint para activar guardar un registro médico
    @PostMapping
     public ResponseEntity <medicalRecords> save(@RequestBody medicalRecords data){
      medicalRecords saveResponseAPI = this.medicalRecordsService.saveMedicalRecords(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };

    //Entpoit para activar obtener todos los registros médicos 
    @GetMapping
     public ResponseEntity <List<medicalRecords>> getAllMedicalRecords(){
      return ResponseEntity.status(HttpStatus.OK).body(this.medicalRecordsService.getAllMedicalRecords());
    };

    //Entpoit para activar obtener un registro médico por id
      @GetMapping(value = "/{id}")
    public ResponseEntity <medicalRecords> getMedicalRecordById(@PathVariable Integer id){
      return ResponseEntity.status(HttpStatus.OK).body(this.medicalRecordsService.getMedicalRecordById(id));
    };
}
