package com.anupam.PediaTrackBackend.db.model;


import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public Family(String name) {
        this.name = name;
    }
}
