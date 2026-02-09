package dataPawBE.demo.dto;

import dataPawBE.demo.models.User;

public record ChangeRoleRequest(User.Role role) {
}
