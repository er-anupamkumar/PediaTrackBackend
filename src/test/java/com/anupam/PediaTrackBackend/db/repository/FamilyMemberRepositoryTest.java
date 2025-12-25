package com.anupam.PediaTrackBackend.db.repository;

import com.anupam.PediaTrackBackend.db.model.Family;
import com.anupam.PediaTrackBackend.db.model.FamilyMember;
import com.anupam.PediaTrackBackend.db.model.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FamilyMemberRepositoryTest {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Test
    void shouldPaginateFamilyMembers() {
        Family family = familyRepository.save(new Family("Smith Family"));

        for (int i = 0; i < 25; i++) {
            FamilyMember member = new FamilyMember();
            member.setFamily(family);
            member.setName("Child " + i);
            member.setGender(Gender.MALE);
            member.setDateOfBirth(LocalDate.of(2018,1,1));
            familyMemberRepository.save(member);
        }

        Page<FamilyMember> page =
                familyMemberRepository.findByFamily(family, PageRequest.of(0, 10));

        assertThat(page.getContent()).hasSize(10);
        assertThat(page.getTotalElements()).isEqualTo(25);
    }
}

