package com.anupam.PediaTrackBackend.api.controller;

import com.anupam.PediaTrackBackend.api.service.AppUserRegistrationService;
import com.anupam.pediatrackbackend.api.generated.model.AppUserCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.AppUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/vi/users")
@RequiredArgsConstructor
public class AppUserController {

  private final AppUserRegistrationService appUserRegistrationService;


  @PostMapping
  public ResponseEntity<AppUserResponse> registerNewAppUser(
      @RequestBody AppUserCreateRequest request) {
    return appUserRegistrationService.registerNewAppUser(request);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<AppUserResponse> getAppUserProfile(@PathVariable UUID userId) {
    // Implementation for retrieving an app user by ID goes here
    return appUserRegistrationService.getAppUserProfile(userId);
  }

  @PutMapping("/{userId}")
  public ResponseEntity<AppUserResponse> updateAppUserProfile(
      @PathVariable UUID userId, @RequestBody AppUserCreateRequest request) {
    // Implementation for updating an app user goes here
    return appUserRegistrationService.updateAppUserProfile(userId, request);
  }
}
