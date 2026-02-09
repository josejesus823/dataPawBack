package dataPawBE.demo.controllers;

import dataPawBE.demo.models.Pet;
import dataPawBE.demo.services.PetService;
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

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {
    @Autowired
    PetService petService;

    //Entpoint para activar guardar una mascota 
    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet data){
      Pet saveResponseAPI = this.petService.savePet(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };

    //Entpoint para activar obtener todas las mascotas
     @GetMapping
    public ResponseEntity <List<Pet>> getAllPets(){
      return ResponseEntity.status(HttpStatus.OK).body(this.petService.getAllPets());
    };

    //Entpoint para activar obtener una mascota por ID
     @GetMapping(value = "/{id}")
    public ResponseEntity <Pet> getPetById(@PathVariable Integer id){
      return ResponseEntity.status(HttpStatus.OK).body(this.petService.getPetById(id));
    };
}
