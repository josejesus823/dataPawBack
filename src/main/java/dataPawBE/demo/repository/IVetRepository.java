package dataPawBE.demo.repository;

import dataPawBE.demo.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVetRepository extends JpaRepository<Vet, Integer> {
}
