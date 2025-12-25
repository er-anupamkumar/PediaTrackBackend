package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.AppUser;
import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.PediaTrackBackend.db.model.FamilyRole;
import com.anupam.PediaTrackBackend.db.model.FamilyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FamilyUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyUserRepository familyUserRepository;

    @Test
    void shouldFindFamilyByAppUser() {
        AppUser user = appUserRepository.save(
                new AppUser("a@b.com", "hash", "Alice")
        );

        Family family = familyRepository.save(
                new Family("Test Family")
        );

        FamilyUser familyUser = new FamilyUser();
        familyUser.setFamily(family);
        familyUser.setAppUser(user);
        familyUser.setRole(FamilyRole.OWNER);

        familyUserRepository.save(familyUser);

        List<FamilyUser> result = familyUserRepository.findByAppUser(user);
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getRole()).isEqualTo(FamilyRole.OWNER);
    }
}
