package com.anupam.PediaTrackBackend.db.model;

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
@Table(name = "health_logs")
public class HealthLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FamilyMember familyMember;

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
