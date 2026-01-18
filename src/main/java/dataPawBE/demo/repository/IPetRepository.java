package dataPawBE.demo.repository;

import dataPawBE.demo.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Integer> {
}
