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
import dataPawBE.demo.models.Pet;
import dataPawBE.demo.services.PetService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/pets")
@Tag (name = "Controlador crud para los servicios de mascotas")

public class PetController {
    @Autowired
    PetService petService;

    @Operation (summary = "Servicio para guardar una mascota")
    @ApiResponses({
      @ApiResponse (responseCode = "200", description = "Mascota guardada exitosamente",
        content = @Content (schema = @Schema (implementation = Pet.class ))
      ),
      @ApiResponse (responseCode = "400", description = "datos inválidos en la petición",
        content = @Content (mediaType = "application/json",
          examples = @ExampleObject (value = """
          {"Mensaje": "Revisa los campos ingresados}
              """) ))
    })

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
