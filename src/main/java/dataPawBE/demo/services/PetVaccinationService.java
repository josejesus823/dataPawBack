package dataPawBE.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dataPawBE.demo.models.PetVaccination;
import dataPawBE.demo.repository.IPetVaccinationRepository;

@Service
public class PetVaccinationService {

    @Autowired
    private IPetVaccinationRepository repository;

    // Guardar una vacunación
    public PetVaccination savePetVaccination(PetVaccination petVaccination) {
        if (petVaccination.getVaccineName() == null || petVaccination.getVaccineName().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Error: el nombre de la vacuna es obligatorio");
        }
        if (petVaccination.getPet() == null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Error: debe seleccionar una mascota");
        }
        return this.repository.save(petVaccination);
    }

    // Obtener todas las vacunaciones
    public List<PetVaccination> getAllPetVaccinations() {
        return this.repository.findAll();
    }

    // Obtener una vacunación por ID
    public PetVaccination getPetVaccinationById(Integer id) {
        Optional<PetVaccination> petVaccination = this.repository.findById(id);
        if (!petVaccination.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No existe una vacunación con ese ID");
        }
        return petVaccination.get();
    }

    // Eliminar una vacunación por ID
    public void deletePetVaccinationById(Integer id) {
        Optional<PetVaccination> petVaccination = this.repository.findById(id);
        if (!petVaccination.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No existe una vacunación con ese ID");
        }
        this.repository.deleteById(id);
    }
}
