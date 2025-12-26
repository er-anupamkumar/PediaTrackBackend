package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.FamilyUser;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyUserRepository extends JpaRepository<FamilyUser, UUID> {

    List<FamilyUser> findByAppUserId(UUID appUserId);

    List<FamilyUser> findByFamilyId(UUID familyId);

    Optional<FamilyUser> findByFamilyIdAndAppUserId(UUID familyId, UUID appUserId);

    boolean existsByFamilyIdAndAppUserId(UUID familyId, UUID appUserId);

    void deleteByFamilyId(UUID familyId);
}
