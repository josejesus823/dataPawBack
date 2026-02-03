package dataPawBE.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import dataPawBE.demo.models.Vet;
import dataPawBE.demo.repository.IVetRepository;

@Service
public class VetService {
    @Autowired
    private IVetRepository repository;

    // Guardar un veterinario
    public Vet saveVet(Vet dataVet) {
        if (dataVet.getVetName() == null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Error el nombre es nulo");
        }
        return this.repository.save(dataVet);
    }

    // Obtener todos los veterinarios
    public List<Vet> getAllVets() {
        return this.repository.findAll();
    }

    // Obtener un veterinario por ID
    public Vet getVetById(Integer id) {
        Optional<Vet> vet = this.repository.findById(id);
        if (!vet.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No existe un veterinario con ese ID");
        }
        return vet.get();
    }

    // Eliminar un veterinario por ID
    public void deleteVetById(Integer id) {
        Optional<Vet> serchId = this.repository.findById(id);
        if (!serchId.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Doesn't exist");
        }
        this.repository.deleteById(id);
    }
}

   


