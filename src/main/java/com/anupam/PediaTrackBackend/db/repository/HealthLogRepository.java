package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.FamilyMember;
import com.anupam.PediaTrackBackend.db.model.HealthLog;
import com.anupam.PediaTrackBackend.db.model.enums.HealthLogType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.UUID;

public interface HealthLogRepository extends JpaRepository<HealthLog, UUID> {


    // Latest-first timeline (UI default)
    Page<HealthLog> findByFamilyMemberOrderByLoggedAtDesc(
            FamilyMember familyMember,
            Pageable pageable
    );

    // Date-range timeline (charts / exports)
    Page<HealthLog> findByFamilyMemberAndLoggedAtBetweenOrderByLoggedAtAsc(
            FamilyMember familyMember,
            Instant start,
            Instant end,
            Pageable pageable
    );

    // Type-filtered logs
    Page<HealthLog> findByFamilyMemberAndLogTypeAndLoggedAtBetween(
            FamilyMember familyMember,
            HealthLogType logType,
            Instant start,
            Instant end,
            Pageable pageable
    );

    // Explicit deletion orchestration
    void deleteByFamilyMember(FamilyMember familyMember);

}
