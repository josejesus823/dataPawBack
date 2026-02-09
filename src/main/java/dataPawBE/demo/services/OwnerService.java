package dataPawBE.demo.services;

import dataPawBE.demo.dto.OwnerUpdateRequest;
import dataPawBE.demo.models.Owner;
import dataPawBE.demo.repository.IOwnerRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class OwnerService {

    private final IOwnerRepository repo;

    public OwnerService(IOwnerRepository repo) {
        this.repo = repo;
    }

    public List<Owner> findAll() {
        return repo.findAll();
    }

    public Owner findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("owner not found"));
    }

    public Owner update(Integer id, OwnerUpdateRequest req) {
        Owner o = findById(id);

        if (req.ownerName() != null) o.setOwnerName(req.ownerName().trim());
        if (req.ownerPhone() != null) o.setOwnerPhone(req.ownerPhone());
        if (req.ownerDni() != null) o.setOwnerDni(req.ownerDni());
        if (req.ownerAddress() != null) o.setOwnerAddress(req.ownerAddress());
        if (req.ownerCity() != null) o.setOwnerCity(req.ownerCity());
        if (req.civilStatus() != null) o.setCivilStatus(req.civilStatus());

        if (req.dateOfBirth() != null) {
            if (req.dateOfBirth().isBlank()) {
                o.setDateOfBirth(null);
            } else {
                try {
                    var sdf = new SimpleDateFormat("yyyy-MM-dd");
                    o.setDateOfBirth(sdf.parse(req.dateOfBirth().trim()));
                } catch (Exception e) {
                    throw new IllegalArgumentException("dateOfBirth must be yyyy-MM-dd");
                }
            }
        }

        return repo.save(o);
    }

    public void delete(Integer id) {
        Owner o = findById(id);
        repo.delete(o);
    }

}