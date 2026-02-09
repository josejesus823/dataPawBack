package dataPawBE.demo.controllers;

import dataPawBE.demo.services.PetVaccinationService;
import dataPawBE.demo.models.PetVaccination;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/petVaccination")
public class PetVaccinationController {
    @Autowired
    PetVaccinationService petVaccinationService;

    //Entpoint para activar Guardar una vacunación
    @PostMapping
    public ResponseEntity <PetVaccination> save(@RequestBody PetVaccination data){
      PetVaccination saveResponseAPI = this.petVaccinationService.savePetVaccination(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };

    //Entpoint para activar obtener todas las vacunaciones
    @GetMapping
    public ResponseEntity <List<PetVaccination>> getAllPetVaccinations(){
      return ResponseEntity.status(HttpStatus.OK).body(this.petVaccinationService.getAllPetVaccinations());
    };

    //Entpoint para activar obtener una vacunación por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity <PetVaccination> getPetVaccinationById(@PathVariable Integer id){
      return ResponseEntity.status(HttpStatus.OK).body(this.petVaccinationService.getPetVaccinationById(id));
    };

     //entpoint para activar eliminar una vacunación por id
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteVaccination(@PathVariable Integer id) {
      petVaccinationService.deletePetVaccinationById(id);
      return ResponseEntity.noContent().build();
    };
}
