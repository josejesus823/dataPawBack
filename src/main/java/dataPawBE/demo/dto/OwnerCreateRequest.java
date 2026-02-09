package dataPawBE.demo.dto;

public record OwnerCreateRequest(
        String ownerName,
        String ownerPhone,
        String ownerEmail,
        String dateOfBirth,
        String password
) {}