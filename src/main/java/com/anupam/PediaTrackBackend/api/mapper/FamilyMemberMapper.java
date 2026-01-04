package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.FamilyMember;
import com.anupam.pediatrackbackend.api.generated.model.FamilyMemberResponse;

public class FamilyMemberMapper {
  public static FamilyMemberResponse toResponse(FamilyMember entity) {
    var dto = new FamilyMemberResponse();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setDateOfBirth(entity.getDateOfBirth());
    dto.setGender(FamilyMemberResponse.GenderEnum.valueOf(entity.getGender().name()));
    return dto;
  }
}
