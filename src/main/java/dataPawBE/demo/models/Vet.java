package dataPawBE.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vets")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="vet_name")
    private String vetName;
    @Column(name="vet_specialty")
    private String vetSpecialty;
    @Column(name="license_number")
    private String licenseNumber;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="vet_address")     
    private String vetAddress;
    @Column(name="clinic_name")         
    private String clinicName;       
    @Column(name="office_hours")      
    private String officeHours;
    @Column(name="profile_image_url")      
    private String profileImageUrl;  
    @Column(name="is_active")
    private Boolean isActive;        

    // vet a medical records
    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL)
    private List<medicalRecords> records;

    public Vet() {}

    public Vet(Integer id, String vetName, String vetSpecialty, String licenseNumber, String email, String phoneNumber,
            String vetAddress, String clinicName, String officeHours, String profileImageUrl, Boolean isActive,
            List<medicalRecords> records) {
        this.id = id;
        this.vetName = vetName;
        this.vetSpecialty = vetSpecialty;
        this.licenseNumber = licenseNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.vetAddress = vetAddress;
        this.clinicName = clinicName;
        this.officeHours = officeHours;
        this.profileImageUrl = profileImageUrl;
        this.isActive = isActive;
        this.records = records;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getVetSpecialty() {
        return vetSpecialty;
    }

    public void setVetSpecialty(String vetSpecialty) {
        this.vetSpecialty = vetSpecialty;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVetAddress() {
        return vetAddress;
    }

    public void setVetAddress(String vetAddress) {
        this.vetAddress = vetAddress;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<medicalRecords> getRecords() {
        return records;
    }

    public void setRecords(List<medicalRecords> records) {
        this.records = records;
    }
    
}