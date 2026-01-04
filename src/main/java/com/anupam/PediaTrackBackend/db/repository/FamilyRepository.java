package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.Family;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, UUID> {
    // intentionally minimal
}
