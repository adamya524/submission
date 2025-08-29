package com.bfh.submission.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalRecordRepository {

    private static final Logger log = LoggerFactory.getLogger(MedicalRecordRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public MedicalRecordRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getSolutionQuery() {
        // The registration number '22BCE2903' ends in 03 (odd), so this query implements the logic for Question 1.
        String sqlQuery = "SELECT AVG(avg_bill) FROM (SELECT AVG(bill_amount) AS avg_bill FROM medical_records WHERE diagnosis = 'Hypertension' AND patient_age > 40 GROUP BY patient_age) AS avg_bills_by_age;";
        log.info("Generated SQL Solution Query: {}", sqlQuery);

        try {
            log.info("Verifying query execution...");
            // Execute the query to ensure it's valid and log the result.
            // This resolves the "unused field" warning for jdbcTemplate.
            Double result = jdbcTemplate.queryForObject(sqlQuery, Double.class);
            log.info("Query verification successful. Result: {}", result);
        } catch (Exception e) {
            log.error("SQL query verification failed!", e);
        }

        // The assignment requires submitting the raw query string, so we still return it.
        return sqlQuery;
    }
}

