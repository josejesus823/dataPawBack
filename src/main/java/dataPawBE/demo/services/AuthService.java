package dataPawBE.demo.services;

import dataPawBE.demo.dto.SingupRequest;
import dataPawBE.demo.models.Owner;
import dataPawBE.demo.models.User;
import dataPawBE.demo.repository.IOwnerRepository;
import dataPawBE.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class AuthService {

    private final IUserRepository users;
    private final IOwnerRepository owners;

    public AuthService(IUserRepository users, IOwnerRepository owners) {
        this.users = users;
        this.owners = owners;
    }

    public Owner signup(SingupRequest req) {
        if (req.email() == null || !req.email().contains("@")) throw new IllegalArgumentException("email invalid");
        if (req.password() == null || req.password().trim().length() < 4) throw new IllegalArgumentException("password invalid");

        String email = req.email().trim().toLowerCase();
        if (users.existsByEmail(email)) throw new IllegalArgumentException("email already exists");

        User u = new User();
        u.setEmail(email);
        u.setPasswordHash(req.password());
        u.setRole(User.Role.USER);
        u = users.save(u);

        Owner o = new Owner();
        o.setOwnerName(req.name() == null ? null : req.name().trim());
        o.setOwnerPhone(req.phone());
        o.setUser(u);

        if (req.dateOfBirth() != null && !req.dateOfBirth().isBlank()) {
            try {
                var sdf = new SimpleDateFormat("yyyy-MM-dd");
                o.setDateOfBirth(sdf.parse(req.dateOfBirth().trim()));
            } catch (Exception e) {
                throw new IllegalArgumentException("dateOfBirth must be yyyy-MM-dd");
            }
        }

        return owners.save(o);
    }
}
