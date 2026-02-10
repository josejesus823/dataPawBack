package dataPawBE.demo.controllers;

import dataPawBE.demo.dto.SingupRequest;
import dataPawBE.demo.models.Owner;
import dataPawBE.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/v1/auth")
@Tag (name = "Controlador crud para la autenticación de usuarios")

public class AuthController {
    @Autowired
    AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @Operation (summary = "Servicio para guardar un nuevo usuario")
    @ApiResponses ({
        @ApiResponse (responseCode = "200", description = "Usuario creado exitosamente",
            content = @Content (schema = @Schema (implementation = Owner.class)) 
        ),
        @ApiResponse (responseCode = "400", description = "Datos inválidos en la petición",
            content = @Content (mediaType = "application/json",
                examples = @ExampleObject (value = """
                    {"Mensaje": "Revisa los campos ingresados"}
                        """) ))
    })


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SingupRequest req) {
        try {
            Owner created = service.signup(req);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}
