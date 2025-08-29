package com.bfh.submission;

import com.bfh.submission.repository.MedicalRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class BfhSubmissionApplicationTests {

    @Autowired
    private MedicalRecordRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void repositoryIsAutowired() {
        assertNotNull(repository);
    }

    @Test
    void solutionQueryIsNotEmpty() {
        String query = repository.getSolutionQuery();
        assertNotNull(query);
        assertTrue(query.length() > 10);
        assertTrue(query.toLowerCase().contains("select"));
    }

    @Test
    void solutionQueryExecutesSuccessfully() {
        String query = repository.getSolutionQuery();
        Double result = jdbcTemplate.queryForObject(query, Double.class);
        assertNotNull(result);
        assertTrue(result > 0);
    }
}

