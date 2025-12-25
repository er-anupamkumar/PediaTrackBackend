package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class HealthLogRepositoryTest {

    @Autowired
    private HealthLogRepository healthLogRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Test
    void shouldFilterLogsByDateRange() {
        Family family = familyRepository.save(new Family("Log Family"));

        FamilyMember member = new FamilyMember();
        member.setFamily(family);
        member.setName("Kid");
        member.setGender(Gender.FEMALE);
        member.setDateOfBirth(LocalDate.of(2020,1,1));
        member = familyMemberRepository.save(member);

        Instant now = Instant.now();

        for (int i = 0; i < 20; i++) {
            HealthLog log = new HealthLog();
            log.setFamilyMember(member);
            log.setLogType(HealthLogType.FEVER);
            log.setLoggedAt(now.minusSeconds(i * 3600));
            log.setTemperatureC(38.0);

            healthLogRepository.save(log);
        }

        Page<HealthLog> page =
                healthLogRepository.findByFamilyMemberOrderByLoggedAtDesc(
                        member,
                        PageRequest.of(0, 5)
                );

        assertThat(page.getContent()).hasSize(5);
    }
}
