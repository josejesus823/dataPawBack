package dataPawBE.demo.dto;

import java.time.LocalDate;

public record MedicalRecordRequest(
        Integer petId,
        Integer vetId,
        LocalDate recordDate,
        String recordType,
        String description,
        String severity,
        String clinicName,
        String attachmentsUrl,
        String notes
) {}
