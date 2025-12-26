package com.anupam.PediaTrackBackend.api.controller;

import com.anupam.pediatrackbackend.api.generated.model.AppUserCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.AppUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/users")
public class AppUserController {

  @PostMapping
  public ResponseEntity<AppUserResponse> registerNewAppUser(
      @RequestBody AppUserCreateRequest request) {
    // Implementation for registering a new app user goes here
    return ResponseEntity.ok(new AppUserResponse());
  }

  @GetMapping("/{userId}")
  public ResponseEntity<AppUserResponse> getAppUserProfile(@PathVariable Long userId) {
    // Implementation for retrieving an app user by ID goes here
    return ResponseEntity.ok(new AppUserResponse());
  }

  @PutMapping("/{userId}")
  public ResponseEntity<AppUserResponse> updateAppUserProfile(
      @PathVariable Long userId, @RequestBody AppUserCreateRequest request) {
    // Implementation for updating an app user goes here
    return ResponseEntity.ok(new AppUserResponse());
  }
}
