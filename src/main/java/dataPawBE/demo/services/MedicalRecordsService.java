package dataPawBE.demo.services;

import dataPawBE.demo.dto.MedicalRecordRequest;
import dataPawBE.demo.models.Pet;
import dataPawBE.demo.models.Vet;
import dataPawBE.demo.models.medicalRecords;
import dataPawBE.demo.repository.IMedicalRecordsRepository;
import dataPawBE.demo.repository.IPetRepository;
import dataPawBE.demo.repository.IVetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class MedicalRecordsService {

    @Autowired
    private final IMedicalRecordsRepository repo;
    private final IPetRepository petRepo;
    private final IVetRepository vetRepo;

    public MedicalRecordsService(
            IMedicalRecordsRepository repo,
            IPetRepository petRepo,
            IVetRepository vetRepo
    ) {
        this.repo = repo;
        this.petRepo = petRepo;
        this.vetRepo = vetRepo;
    }

    public medicalRecords create(MedicalRecordRequest req) {
        validate(req);

        Pet pet = petRepo.findById(req.petId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Pet not found"));

        Vet vet = null;
        if (req.vetId() != null) {
            vet = vetRepo.findById(req.vetId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Vet not found"));
        }

        medicalRecords mr = new medicalRecords();
        mr.setPet(pet);
        mr.setVet(vet);
        mr.setClinic_name(req.clinicName().trim());
        mr.setRecord_type(req.recordType());
        mr.setDescription(req.description());
        mr.setSeverity(req.severity());
        mr.setAttachments_url(req.attachmentsUrl());
        mr.setNotes(req.notes());

        if (req.recordDate() != null) {
            try {
                mr.setRecord_date((req.recordDate()));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "recordDate must be yyyy-MM-dd");
            }
        }

        return repo.save(mr);
    }

    public java.util.List<medicalRecords> getAllMedicalRecords() {
        return repo.findAll();
    }

    public medicalRecords getMedicalRecordById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medical record not found"));
    }

    public medicalRecords update(Integer id, MedicalRecordRequest req) {
        validate(req);

        medicalRecords mr = getMedicalRecordById(id);

        Pet pet = petRepo.findById(req.petId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Pet not found"));

        Vet vet = null;
        if (req.vetId() != null) {
            vet = vetRepo.findById(req.vetId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Vet not found"));
        }

        mr.setPet(pet);
        mr.setVet(vet);
        mr.setClinic_name(req.clinicName().trim());
        mr.setRecord_type(req.recordType());
        mr.setDescription(req.description());
        mr.setSeverity(req.severity());
        mr.setAttachments_url(req.attachmentsUrl());
        mr.setNotes(req.notes());

        if (req.recordDate() != null ) {
            try {
                mr.setRecord_date((req.recordDate()));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "recordDate must be yyyy-MM-dd");
            }
        } else {
            mr.setRecord_date(null);
        }

        return repo.save(mr);
    }

    public void delete(Integer id) {
        medicalRecords mr = getMedicalRecordById(id);
        repo.delete(mr);
    }

    private void validate(MedicalRecordRequest req) {
        if (req.clinicName() == null || req.clinicName().trim().length() < 3) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "clinicName is required");
        }
        if (req.petId() == null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "petId is required");
        }
    }
}

