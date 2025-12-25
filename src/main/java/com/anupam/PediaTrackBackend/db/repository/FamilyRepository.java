package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyRepository extends JpaRepository<Family, UUID> {
    // intentionally minimal
}
