package com.anupam.PediaTrackBackend.api.mapper;

import com.anupam.PediaTrackBackend.db.model.AppUser;
import com.anupam.pediatrackbackend.api.generated.model.AppUserResponse;

public class AppUserMapper {
    public static AppUserResponse toResponse(AppUser entity) {
        AppUserResponse dto = new AppUserResponse();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFullName(entity.getFullName());
        return dto;
    }
}
