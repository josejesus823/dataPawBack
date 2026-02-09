package dataPawBE.demo.services;

import dataPawBE.demo.dto.ChangeRoleRequest;
import dataPawBE.demo.models.User;
import dataPawBE.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IUserRepository repo;

    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    public User changeRole(Integer userId, ChangeRoleRequest req) {
        if (req == null || req.role() == null) {
            throw new IllegalArgumentException("role is required (USER or ADMIN)");
        }

        User user = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));

        user.setRole(req.role());
        return repo.save(user);
    }
}
