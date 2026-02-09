package dataPawBE.demo.services;

import dataPawBE.demo.dto.OwnerCreateRequest;
import dataPawBE.demo.models.Owner;
import dataPawBE.demo.repository.IOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class OwnerService {
    @Autowired
    private final IOwnerRepository repository;

    public OwnerService(IOwnerRepository repository) {
        this.repository = repository;
    }

    public Owner create(OwnerCreateRequest req) {
        // Validaciones mínimas
        if (req.ownerName() == null || req.ownerName().trim().length() < 3) {
            throw new IllegalArgumentException("ownerName is required");
        }
        if (req.ownerEmail() == null || !req.ownerEmail().contains("@")) {
            throw new IllegalArgumentException("ownerEmail is invalid");
        }

        Owner o = new Owner();
        o.setOwnerName(req.ownerName().trim());
        o.setOwnerPhone(req.ownerPhone());
        o.setOwnerEmail(req.ownerEmail().trim().toLowerCase());
        o.setPasswordHash(req.password());

        if (req.dateOfBirth() != null && !req.dateOfBirth().isBlank()) {
            try {
                var sdf = new SimpleDateFormat("yyyy-MM-dd");
                o.setDateOfBirth(sdf.parse(req.dateOfBirth().trim()));
            } catch (Exception e) {
                throw new IllegalArgumentException("dateOfBirth must be yyyy-MM-dd");
            }
        }

        return repository.save(o);
    }
}
