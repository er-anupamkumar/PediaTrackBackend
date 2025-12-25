package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepositoryTest {
    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    void shouldSaveAndFindByEmail() {
        AppUser user = new AppUser();
        user.setEmail("test@example.com");
        user.setPasswordHash("hash");
        user.setFullName("Test User");

        appUserRepository.save(user);

        Optional<AppUser> found = appUserRepository.findByEmail("test@example.com");
        assertThat(found).isPresent();
        assertThat(found.get().getFullName()).isEqualTo("Test User");
    }


    @Test
    void shouldCheckEmailExists() {
        AppUser user = new AppUser();
        user.setEmail("exists@example.com");
        user.setPasswordHash("hash");

        appUserRepository.save(user);

        assertThat(appUserRepository.existsByEmail("exists@example.com")).isTrue();
        assertThat(appUserRepository.existsByEmail("missing@example.com")).isFalse();
    }
}
