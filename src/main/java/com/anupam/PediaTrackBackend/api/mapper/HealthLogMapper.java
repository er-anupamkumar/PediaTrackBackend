package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.HealthLog;
import com.anupam.pediatrackbackend.api.generated.model.HealthLogCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.HealthLogResponse;
import com.anupam.pediatrackbackend.api.generated.model.HealthLogType;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.ZoneOffset;

public class HealthLogMapper {
  public static HealthLogResponse toResponse(HealthLog entity) {
    var dto = new HealthLogResponse();
    dto.setId(entity.getId());
    dto.setLogType(HealthLogType.valueOf(entity.getLogType().name()));
    dto.setLoggedAt(entity.getLoggedAt().atOffset(ZoneOffset.UTC));
    dto.setTemperatureC(entity.getTemperatureC());
    dto.setTemperatureF(entity.getTemperatureF());
    dto.setMedicationName(entity.getMedicationName());
    dto.setDosage(entity.getDosage());
    dto.setNotes(entity.getNotes());
    return dto;
  }

  public static HealthLog toEntity(HealthLogCreateRequest request){
    var entity = new HealthLog();
    entity.setLogType(com.anupam.PediaTrackBackend.db.model.enums.HealthLogType.valueOf(request.getLogType().name()));
    entity.setLoggedAt(request.getLoggedAt().toInstant().atOffset(ZoneOffset.UTC).toInstant());
    entity.setTemperatureC(request.getTemperatureC());
    entity.setTemperatureF(entity.getTemperatureF());
    entity.setMedicationName(request.getMedicationName());
    entity.setDosage(request.getDosage());
    entity.setNotes(request.getNotes());
    return entity;
  }

  private static Double cToF(Double c) {
    return (c * 9 / 5) + 32;
  }

  private static Double ftoC(Double f) {
    return (f - 32) * 5 / 9;
  }
}
