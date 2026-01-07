package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.AppUser;
import com.anupam.pediatrackbackend.api.generated.model.AppUserCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.AppUserResponse;

import java.time.OffsetDateTime;

public class AppUserMapper {
  public static AppUserResponse toResponse(AppUser entity) {
    var dto = new AppUserResponse();
    dto.setId(entity.getId());
    dto.setEmail(entity.getEmail());
    dto.setFullName(entity.getFullName());
    dto.setCreatedAt(OffsetDateTime.from(entity.getCreatedAt()));
    return dto;
  }

  public static AppUser toEntity(AppUserCreateRequest request) {
    var entity = new AppUser();
    entity.setEmail(request.getEmail());
    entity.setFullName(request.getFullName());
    entity.setPasswordHash(
        request.getPassword()); // In real scenarios, hash the password before storing
    return entity;
  }

  public static AppUser updateEntity(AppUser entity, AppUserCreateRequest request) {
    entity.setEmail(request.getEmail());
    entity.setFullName(request.getFullName());
    entity.setPasswordHash(
            request.getPassword()); // In real scenarios, hash the password before storing
    return entity;
  }

}
