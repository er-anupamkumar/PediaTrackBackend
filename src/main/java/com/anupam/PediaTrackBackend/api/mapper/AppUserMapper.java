package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.AppUser;
import com.anupam.pediatrackbackend.api.generated.model.AppUserCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.AppUserResponse;

public class AppUserMapper {
  public static AppUserResponse toResponse(AppUser entity) {
    var dto = new AppUserResponse();
    dto.setId(entity.getId());
    dto.setEmail(entity.getEmail());
    dto.setFullName(entity.getFullName());
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
}
