package dataPawBE.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="owner_id")
    private Integer id;

    @Column(name="owner_name")
    private String ownerName;
    @Column(name="owner_dni")
    private String ownerDni;
    @Column(name="owner_address")
    private String ownerAddress;
    @Column(name="owner_phone")
    private String ownerPhone;
    @Column(name="owner_city")
    private String ownerCity;
    @Column(name="owner_salary")
    private Float ownerSalary;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @Column(name="civil_status")
    private String civilStatus;

    // owner a pets
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets;

    @OneToOne (optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public Owner() {}

    public Owner(Integer id, String ownerName, String ownerDni, String ownerAddress, String ownerPhone,
          String ownerCity, Float ownerSalary, Date dateOfBirth, String civilStatus,
            List<Pet> pets) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerDni = ownerDni;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
        this.ownerCity = ownerCity;
        this.ownerSalary = ownerSalary;
        this.dateOfBirth = dateOfBirth;
        this.civilStatus = civilStatus;
        this.pets = pets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerDni() {
        return ownerDni;
    }

    public void setOwnerDni(String ownerDni) {
        this.ownerDni = ownerDni;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public Float getOwnerSalary() {
        return ownerSalary;
    }

    public void setOwnerSalary(Float ownerSalary) {
        this.ownerSalary = ownerSalary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
    
}