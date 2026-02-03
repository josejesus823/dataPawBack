package dataPawBE.demo.controllers;

import dataPawBE.demo.services.PetVaccinationService;
import dataPawBE.demo.models.PetVaccination;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/petVaccination")
public class PetVaccinationController {
    @Autowired
    PetVaccinationService petVaccinationService;

    @PostMapping
    public ResponseEntity <PetVaccination> save(@RequestBody PetVaccination data){
      PetVaccination saveResponseAPI = this.petVaccinationService.savePetVaccination(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };
}
