package dataPawBE.demo.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pet_vaccinations")
public class PetVaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccination_id")
    private Integer vaccinationId;

    // Relación con Pet
    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    private Pet pet; 

    @Column(name = "vaccine_name")
    private String vaccineName;

    @Column(name = "vaccine_type")
    private String vaccineType;

    @Column(name = "dose_number")
    private Integer doseNumber;
    
    @Column(name = "applied_date")
    private Date appliedDate;
    
    @Column(name = "next_due_date")
    private Date nextDueDate;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "manufacturer")
    private String manufacturer;
    
    @Column(columnDefinition = "TEXT")
    private String notes;

    // constructores

    public PetVaccination() {}

    public PetVaccination(Integer vaccinationId, Pet pet, String vaccineName, String vaccineType,
            Integer doseNumber, Date appliedDate, Date nextDueDate, String batchNumber, String manufacturer,
            String notes) {
        this.vaccinationId = vaccinationId;
        this.pet = pet;
        this.vaccineName = vaccineName;
        this.vaccineType = vaccineType;
        this.doseNumber = doseNumber;
        this.appliedDate = appliedDate;
        this.nextDueDate = nextDueDate;
        this.batchNumber = batchNumber;
        this.manufacturer = manufacturer;
        this.notes = notes;
    }

    // getters & setters

    public Integer getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Integer vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Integer getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(Integer doseNumber) {
        this.doseNumber = doseNumber;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Date getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(Date nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}