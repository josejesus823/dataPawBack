package dataPawBE.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    private Integer petId;

    @Column(name="owner_id")
    private Integer ownerId;

    @Column(name="pet_name")
    private String petName;

    @Column(name="pet_type")
    private String petType;

    @Column(name="pet_breed")
    private String petBreed;

    @Column(name="pet_sex")
    private String petSex;

    private String color;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    private Float weight;

    @Column(name="code_microship")
    private UUID codeMicroship;

    public Pet() {
    }

    public Pet(Integer petId, Integer ownerId, String petName, String petType, String petBreed, String petSex, String color, LocalDate dateOfBirth, Float weight, UUID codeMicroship) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.petName = petName;
        this.petType = petType;
        this.petBreed = petBreed;
        this.petSex = petSex;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.codeMicroship = codeMicroship;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public UUID getCodeMicroship() {
        return codeMicroship;
    }

    public void setCodeMicroship(UUID codeMicroship) {
        this.codeMicroship = codeMicroship;
    }
}

