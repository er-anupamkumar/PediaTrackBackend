package com.anupam.PediaTrackBackend.db.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(
        name = "families",
        indexes = {
                @Index(name = "idx_families_name", columnList = "name")
        }
)
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name; // e.g. "Sharma Family"

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    // ---------- Bidirectional ----------
    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FamilyMember> members = new ArrayList<>();

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FamilyUser> users = new ArrayList<>(); // only deletes join table rows
}
