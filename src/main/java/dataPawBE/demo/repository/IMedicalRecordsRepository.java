package dataPawBE.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dataPawBE.demo.models.medicalRecords;

@Repository
public interface IMedicalRecordsRepository extends JpaRepository<medicalRecords, Integer>{
    
}
