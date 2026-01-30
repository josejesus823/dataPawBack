package dataPawBE.demo.repository;

import dataPawBE.demo.models.PetVaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetVaccinationRepository extends JpaRepository<PetVaccination, Integer> {
}
