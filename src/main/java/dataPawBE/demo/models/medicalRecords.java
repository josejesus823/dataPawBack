package dataPawBE.demo.models;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "medical_records")
public class medicalRecords {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="record_id")
    private Integer record_id;

    // FIXED: Using the Pet entity class instead of Integer
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @Column(name="record_date")
    private LocalDate record_date;

    @Column(name="record_type")
    private String record_type;

    @Column(name="description")
    private String description;

    @Column(name="severity")
    private String severity;

    @ManyToOne
    @JoinColumn(name="vet_id")
    private Vet vet;

    @Column(name="clinic_name")
    private String clinic_name;

    @Column(name="attachments_url")
    private String attachments_url;

    @Column(name="notes")
    private String notes;

    public medicalRecords() {
    }

    public medicalRecords(Integer record_id, Pet pet, LocalDate record_date, String record_type, String description, String severity, Vet vet, String clinic_name, String attachments_url, String notes) {
        this.record_id = record_id;
        this.pet = pet;
        this.record_date = record_date;
        this.record_type = record_type;
        this.description = description;
        this.severity = severity;
        this.vet = vet;
        this.clinic_name = clinic_name;
        this.attachments_url = attachments_url;
        this.notes = notes;
    }

    public Integer getRecord_id() {
        return this.record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getRecord_date() {
        return this.record_date;
    }

    public void setRecord_date(LocalDate record_date) {
        this.record_date = record_date;
    }

    public String getRecord_type() {
        return this.record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return this.severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Vet getVet() {
        return this.vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public String getClinic_name() {
        return this.clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getAttachments_url() {
        return this.attachments_url;
    }

    public void setAttachments_url(String attachments_url) {
        this.attachments_url = attachments_url;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}