package com.anupam.PediaTrackBackend.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "family_members",
        indexes = {
                @Index(name = "idx_family_members_family_id", columnList = "family_id")
        }
)
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    // ---------- Bidirectional ----------
    @OneToMany(mappedBy = "familyMember", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HealthLog> healthLogs = new ArrayList<>();
}
