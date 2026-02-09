package dataPawBE.demo.dto;

public record SingupRequest(
        String name,
        String phone,
        String email,
        String dateOfBirth,
        String password
) {}

