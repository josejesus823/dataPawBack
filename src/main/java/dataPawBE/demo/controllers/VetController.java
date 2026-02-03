package dataPawBE.demo.controllers;

//Falta importar el VetService
import dataPawBE.demo.models.Vet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/vet")
public class VetController {
    @Autowired
    VetService vetService;

    @PostMapping
    public ResponseEntity <Vet> save(@RequestBody Vet data){
      Vet saveResponseAPI = this.vetService.saveVet(data);
      return ResponseEntity.status(HttpStatus.OK).body(saveResponseAPI);
    };
}
