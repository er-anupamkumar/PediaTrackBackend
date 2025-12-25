package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.PediaTrackBackend.db.model.FamilyMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, UUID> {

    Page<FamilyMember> findByFamily(Family family, Pageable pageable);
    long countByFamily(Family family);
}
