package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.AppUser;
import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.PediaTrackBackend.db.model.FamilyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FamilyUserRepository extends JpaRepository<FamilyUser, UUID> {

    List<FamilyUser> findByAppUser(AppUser appUser);

    List<FamilyUser> findByFamily(Family family);

    Optional<FamilyUser> findByFamilyAndAppUser(Family family, AppUser appUser);

    boolean existsByFamilyAndAppUser(Family family, AppUser appUser);

    void deleteByFamily(Family family);
}
