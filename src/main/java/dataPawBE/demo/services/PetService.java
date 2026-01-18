package dataPawBE.demo.services;

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


    public Pet savePet(Pet dataPet){

        if(dataPet.getPetName() == null || dataPet.getPetName().length() < 2){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Name isn't valid"
            );
        }

        return this.petRepository.save(dataPet);
    }
}
