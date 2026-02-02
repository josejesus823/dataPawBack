package dataPawBE.demo.dto;

public record OwnerCreateRequest(
        String ownerName,
        String ownerDni,
        String ownerAddress,
        String ownerPhone,
        String ownerEmail,
        String ownerCity,
        Float ownerSalary,
        String dateOfBirth,
        String civilStatus
) {}