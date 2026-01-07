package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.pediatrackbackend.api.generated.model.FamilyCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.FamilyResponse;
import com.anupam.pediatrackbackend.api.generated.model.FamilyUpdateRequest;

public class FamilyMapper {
  public static FamilyResponse toResponse(Family entity) {
    var dto = new FamilyResponse();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    return dto;
  }

  public static Family toEntity(FamilyCreateRequest request) {
    var enitity = new Family();
    enitity.setName(request.getName());
    return enitity;
  }

  public static Family updateEntity(Family entity, FamilyUpdateRequest request) {
    entity.setName(request.getName());
    return entity;
  }


}
