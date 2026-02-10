package dataPawBE.demo.controllers;

import dataPawBE.demo.dto.ChangeRoleRequest;
import dataPawBE.demo.models.User;
import dataPawBE.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/users")
@Tag (name = "Controlador crud para los servicios de usuarios")

public class UserController {

    @Autowired
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Operation (summary = "Servicio para guardar el usuario")
    @ApiResponses ({
        @ApiResponse (responseCode = "200", description = "Usuario guardado exitosamente",
            content = @Content (schema = @Schema (implementation = User.class)) 
        ),
        @ApiResponse (responseCode = "400", description = "Datos inválidos en la petición",
            content = @Content (mediaType = "application/json",
                examples = @ExampleObject (value = """
                {"Mensaje": "Revisa los campos ingresados"}
                        """ ) ))
    })


    @PatchMapping("/{id}/role")
    public ResponseEntity<?> changeRole(@PathVariable Integer id, @RequestBody ChangeRoleRequest req) {
        try {
            User updated = service.changeRole(id, req);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}