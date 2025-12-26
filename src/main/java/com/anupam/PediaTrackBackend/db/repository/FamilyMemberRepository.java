package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.PediaTrackBackend.db.model.FamilyMember;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID> {
    Page<FamilyMember> findByFamilyId(UUID familyId, Pageable pageable);
    long countByFamily(Family family);
}
