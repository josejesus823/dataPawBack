package dataPawBE.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dataPawBE.demo.models.Vet;
import dataPawBE.demo.services.VetService;


@RestController
@RequestMapping("/api/v1/vet")
public class VetController {
    @Autowired
    VetService vetService;

    //Entpoint para activar guardar un vet
    @PostMapping
    public ResponseEntity <Vet> save(@RequestBody Vet data){
      Vet saveResponseAPI = this.vetService.saveVet(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };

    //Entpoit para activar buscar por id el vet 
    @GetMapping(value = "/{id}")
    public ResponseEntity <Vet> getVetById(@PathVariable Integer id){
      return ResponseEntity.status(HttpStatus.OK).body(this.vetService.getVetById(id));
    };

    //Entpoit para activar buscar todos vet 
    @GetMapping
    public ResponseEntity <List<Vet>> getAllVets(){
      return ResponseEntity.status(HttpStatus.OK).body(this.vetService.getAllVets());
    };

    //Entpoint para activar eliminar un vet por id
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteVet(@PathVariable Integer id) {
      vetService.deleteVetById(id);
      return ResponseEntity.noContent().build();
    };
}

    




  