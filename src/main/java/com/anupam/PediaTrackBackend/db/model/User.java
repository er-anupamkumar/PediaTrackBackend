package com.anupam.PediaTrackBackend.db.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
        name = "users",
        indexes = {
                @Index(name = "idx_users_email", columnList = "email")
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String fullName;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    @OneToMany(mappedBy = "user")
    private List<FamilyUser> families = new ArrayList<>();

}
