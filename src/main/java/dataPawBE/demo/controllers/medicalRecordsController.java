package dataPawBE.demo.controllers;

import dataPawBE.demo.dto.MedicalRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dataPawBE.demo.models.medicalRecords;
import dataPawBE.demo.services.MedicalRecordsService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/medicalRecords")
public class medicalRecordsController {
    @Autowired
    MedicalRecordsService service;

    public void MedicalRecordsController(MedicalRecordsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<medicalRecords> create(@RequestBody MedicalRecordRequest req) {
        medicalRecords created = service.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<medicalRecords> getAll() {
        return service.getAllMedicalRecords();
    }

    @GetMapping("/{id}")
    public medicalRecords getById(@PathVariable Integer id) {
        return service.getMedicalRecordById(id);
    }

    @PutMapping("/{id}")
    public medicalRecords update(@PathVariable Integer id, @RequestBody MedicalRecordRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
