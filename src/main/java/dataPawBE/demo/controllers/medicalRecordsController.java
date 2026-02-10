package dataPawBE.demo.controllers;

import java.util.List;

import dataPawBE.demo.dto.MedicalRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dataPawBE.demo.models.medicalRecords;
import dataPawBE.demo.services.MedicalRecordsService;
import dataPawBE.demo.dto.MedicalRecordRequest;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/api/v1/medicalRecords")
@Tag (name = "Controlador crud para los serviicos de registros médicos")

public class medicalRecordsController {
    @Autowired
    MedicalRecordsService service;

    @Operation (summary = "Servicio para guardar un registro médico")
    @ApiResponses({
        @ApiResponse (responseCode = "200", description = "Registro médico guardado exitosamente",
           content = @Content (schema = @Schema (implementation = medicalRecords.class)) 
        ),
        @ApiResponse (responseCode = "400", description = "datos inválidos en la petición",
            content = @Content (mediaType = "application/json",
                examples = @ExampleObject (value = """
                {"Mensaje": "Revisa los campos ingresados"}
                        """ )))
    })

     //Entpoint para activar guardar un registro médico
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
