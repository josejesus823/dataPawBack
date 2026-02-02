package dataPawBE.demo.controllers;

import dataPawBE.demo.dto.OwnerCreateRequest;
import dataPawBE.demo.models.Owner;
import dataPawBE.demo.services.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService service;

    public OwnerController(OwnerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OwnerCreateRequest req) {
        try {
            Owner created = service.create(req);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }
}
