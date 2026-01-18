package dataPawBE.demo.controllers;

import dataPawBE.demo.models.Pet;
import dataPawBE.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {
    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet data){
      Pet saveResponseAPI = this.petService.savePet(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };
}
