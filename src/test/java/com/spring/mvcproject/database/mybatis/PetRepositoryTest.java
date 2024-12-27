package com.spring.mvcproject.database.mybatis;

import com.spring.mvcproject.database.mybatis.entity.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetRepositoryTest {

    @Autowired
    private PetRepository petRepository;

    @Test
    void saveTest() {
        Pet pet = Pet.builder()
                .petName("둘기둘기")
                .petAge(1)
                .injection(false)
                .build();

        petRepository.save(pet);
    }

}