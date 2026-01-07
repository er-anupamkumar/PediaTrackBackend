package com.anupam.PediaTrackBackend.api.service;

import com.anupam.pediatrackbackend.api.generated.model.AppUserCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.AppUserResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AppUserRegistrationService {

    ResponseEntity<AppUserResponse> registerNewAppUser(AppUserCreateRequest request);

    ResponseEntity<AppUserResponse> getAppUserProfile(UUID userId);

    ResponseEntity<AppUserResponse> updateAppUserProfile(UUID userId, AppUserCreateRequest request);
}
