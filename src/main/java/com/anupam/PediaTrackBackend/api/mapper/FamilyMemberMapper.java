package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.PediaTrackBackend.db.model.FamilyMember;
import com.anupam.pediatrackbackend.api.generated.model.*;

import java.util.UUID;

public class FamilyMemberMapper {
  public static FamilyMemberResponse toResponse(FamilyMember entity) {
    var dto = new FamilyMemberResponse();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setDateOfBirth(entity.getDateOfBirth());
    dto.setGender(Gender.valueOf(entity.getGender().name()));
    dto.setFamilyId(entity.getFamily().getId());
    return dto;
  }

  public static FamilyMember toEntity(Family family, FamilyMemberCreateRequest request) {
    var entity = new FamilyMember();
    entity.setName(request.getName());
    entity.setFamily(family);
    entity.setDateOfBirth(request.getDateOfBirth());
    entity.setGender(
        com.anupam.PediaTrackBackend.db.model.enums.Gender.valueOf(request.getGender().name()));
    return entity;
  }

  public static FamilyMember updateEntity(FamilyMember entity, Family family ,FamilyMemberUpdateRequest request) {
    entity.setName(request.getName());
    entity.setDateOfBirth(request.getDateOfBirth());
    entity.setGender(
            com.anupam.PediaTrackBackend.db.model.enums.Gender.valueOf(request.getGender().name()));
    entity.setFamily(family);
    return entity;
  }
}
