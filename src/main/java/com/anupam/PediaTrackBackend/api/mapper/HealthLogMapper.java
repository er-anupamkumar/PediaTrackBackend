package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.HealthLog;
import com.anupam.pediatrackbackend.api.generated.model.HealthLogResponse;
import com.anupam.pediatrackbackend.api.generated.model.HealthLogType;

import java.time.ZoneOffset;

public class HealthLogMapper {
    public static HealthLogResponse toResponse(HealthLog entity) {
        HealthLogResponse dto = new HealthLogResponse();
        dto.setId(entity.getId());
        dto.setLogType(HealthLogType.valueOf(entity.getLogType().name()));
        dto.setLoggedAt(entity.getLoggedAt().atOffset(ZoneOffset.UTC));
        dto.setTemperatureC(entity.getTemperatureC());
        dto.setTemperatureF(cToF(entity.getTemperatureC()));
        dto.setMedicationName(entity.getMedicationName());
        dto.setDosage(entity.getDosage());
        dto.setNotes(entity.getNotes());
        return dto;
    }

    private static Double cToF(Double c) {
        if (c == null) return null;
        return (c * 9 / 5) + 32;
    }

}
