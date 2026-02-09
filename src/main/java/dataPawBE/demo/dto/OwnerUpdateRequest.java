package dataPawBE.demo.dto;

public record OwnerUpdateRequest(
        String ownerName,
        String ownerPhone,
        String ownerDni,
        String ownerAddress,
        String ownerCity,
        String civilStatus,
        String dateOfBirth
) {}