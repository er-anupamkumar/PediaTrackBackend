package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.pediatrackbackend.api.generated.model.FamilyResponse;

public class FamilyMapper {
    public static FamilyResponse toResponse(Family entity) {
        FamilyResponse dto = new FamilyResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
