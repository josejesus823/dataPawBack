package dataPawBE.demo.services;

import java.util.List;
import java.util.Optional;

import dataPawBE.demo.models.Pet;
import dataPawBE.demo.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PetService {
    @Autowired
    private IPetRepository petRepository;

    // Guardar una mascota
    public Pet savePet(Pet dataPet) {
        if (dataPet.getPetName() == null || dataPet.getPetName().length() < 2) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Name isn't valid");
        }
        if (dataPet.getOwner() == null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Error: debe seleccionar un propietario");
        }
        return this.petRepository.save(dataPet);
    }

    // Obtener todas las mascotas
    public List<Pet> getAllPets() {
        return this.petRepository.findAll();
    }

    // Obtener una mascota por ID
    public Pet getPetById(Integer id) {
        Optional<Pet> pet = this.petRepository.findById(id);
        if (!pet.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No existe una mascota con ese ID");
        }
        return pet.get();
    }
}
