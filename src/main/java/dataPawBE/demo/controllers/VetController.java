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

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/api/v1/vet")
@Tag (name = "Controlador crud para los servicios de veterinarios")

public class VetController {
    @Autowired
    VetService vetService;

  @Operation (summary = "Servicio para guardar un veterinario")
  @ApiResponses({
    @ApiResponse (responseCode = "200", description = "Veterinario guardado exitosamente",
      content = @Content (schema = @Schema (implementation = Vet.class))
    ),
    @ApiResponse (responseCode = "400", description = "datos inválidos en la petición",
      content = @Content (mediaType = "application/json",
        examples = @ExampleObject (value = """
        {"mensaje": "Revisa los campos ingresados"}
            """) ))
  })

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

    //Entpoit para activar  buscar todos vet 
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

    




  