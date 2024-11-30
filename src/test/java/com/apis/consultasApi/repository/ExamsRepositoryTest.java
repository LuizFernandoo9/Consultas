package com.apis.consultasApi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.apis.consultasApi.model.ExamsModel;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class ExamsRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void testFindByNameAndObservation() {

    }

    private ExamsModel createExam(){}
}
