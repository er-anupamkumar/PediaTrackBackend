package com.anupam.PediaTrackBackend.db.model;

import com.anupam.PediaTrackBackend.db.model.enums.HealthLogType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "health_logs",
        indexes = {
                @Index(name = "idx_log_member_time", columnList = "family_member_id, loggedAt"),
                @Index(name = "idx_log_type", columnList = "logType"),
                @Index(name = "idx_log_logged_at", columnList = "loggedAt")
        }
)
public class HealthLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "family_member_id", nullable = false)
    private FamilyMember familyMember; // NO cascade

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HealthLogType logType;

    @Column(nullable = false)
    private Instant loggedAt;

    private Double temperatureC;
    private Double temperatureF;

    private String medicationName;
    private String dosage;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();
}
