package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.HealthLog;
import java.time.Instant;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthLogRepository extends JpaRepository<HealthLog, UUID> {


    Page<HealthLog> findByFamilyMemberIdAndLoggedAtBetween(UUID memberId, Instant start, Instant end, Pageable pageable);

    Page<HealthLog> findByFamilyMemberId(UUID memberId, Pageable pageable);

}
