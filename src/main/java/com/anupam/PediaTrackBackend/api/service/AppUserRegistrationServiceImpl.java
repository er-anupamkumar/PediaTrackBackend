package com.anupam.PediaTrackBackend.api.service;

import static com.anupam.PediaTrackBackend.api.mapper.AppUserMapper.*;

import com.anupam.PediaTrackBackend.db.model.AppUser;
import com.anupam.PediaTrackBackend.db.repository.AppUserRepository;
import com.anupam.pediatrackbackend.api.generated.model.AppUserCreateRequest;
import com.anupam.pediatrackbackend.api.generated.model.AppUserResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserRegistrationServiceImpl implements AppUserRegistrationService{
    AppUserRepository appUserRepository;

/**
* Method to register a new application user
 * @param request : AppUserCreateRequest
 * @return: ResponseEntity<AppUserResponse>
*/
    @Override
    public ResponseEntity<AppUserResponse> registerNewAppUser(AppUserCreateRequest request) {
        AppUser appUser = toEntity(request);
        var user = appUserRepository.save(appUser);
        var response = toResponse(user);
        return ResponseEntity.ok().body(response);
    }

    /**
* Method to get application user profile
 * @param userId : UUID
 * @return : ResponseEntity<AppUserResponse>
*/
    @Override
    public ResponseEntity<AppUserResponse> getAppUserProfile(UUID userId) {
        var userOpt = appUserRepository.findById(userId);
        if (userOpt.isPresent()) {
            var response = toResponse(userOpt.get());
            return ResponseEntity.ok().body(response);
        }else
        {
            return ResponseEntity.notFound().build();
        }
    }

/**
* Method to update application user profile
 * @param userId : UUID
 * @param request : AppUserCreateRequest
 * @return : ResponseEntity<AppUserResponse>
*/
    @Override
    public ResponseEntity<AppUserResponse> updateAppUserProfile(UUID userId, AppUserCreateRequest request) {
        var userOpt = appUserRepository.findById(userId);
        if (userOpt.isPresent()) {
            var user = updateEntity(userOpt.get(), request);
            var entity = appUserRepository.save(user);
            return ResponseEntity.ok().body(toResponse(entity));
        }else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
