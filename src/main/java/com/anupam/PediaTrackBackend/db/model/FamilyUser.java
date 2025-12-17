package com.anupam.PediaTrackBackend.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "family_users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"family_id", "user_id"})
        },
        indexes = {
                @Index(name = "idx_family_users_family_id", columnList = "family_id"),
                @Index(name = "idx_family_users_user_id", columnList = "user_id")
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FamilyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // NO cascade

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FamilyRole role;

    @Column(nullable = false)
    private Instant joinedAt = Instant.now();
}
