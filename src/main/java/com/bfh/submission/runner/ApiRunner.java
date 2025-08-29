package com.bfh.submission.runner;

import com.bfh.submission.dto.SolutionRequest;
import com.bfh.submission.dto.WebhookRequest;
import com.bfh.submission.dto.WebhookResponse;
import com.bfh.submission.repository.MedicalRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ApiRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ApiRunner.class);

    private final WebClient webClient;
    private final MedicalRecordRepository medicalRecordRepository;

    @Value("${api.details.name}")
    private String name;
    @Value("${api.details.regNo}")
    private String regNo;
    @Value("${api.details.email}")
    private String email;

    public ApiRunner(WebClient webClient, MedicalRecordRepository medicalRecordRepository) {
        this.webClient = webClient;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting API runner...");
        generateWebhookAndSubmitSolution();
    }

    private void generateWebhookAndSubmitSolution() {
        WebhookRequest request = new WebhookRequest(name, regNo, email);
        log.info("Step 1: Generating Webhook with details: {}", request);

        webClient.post()
            .uri("/generateWebhook/JAVA")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(WebhookResponse.class)
            .doOnSuccess(response -> {
                log.info("Webhook generated successfully. Response: {}", response);
                submitSolution(response);
            })
            .doOnError(error -> log.error("Error generating webhook: ", error))
            .subscribe();
    }

    private void submitSolution(WebhookResponse webhookResponse) {
        String sqlQuery = medicalRecordRepository.getSolutionQuery();
        SolutionRequest solution = new SolutionRequest(sqlQuery);
        log.info("Step 2: Submitting solution: {}", solution);

        webClient.post()
            .uri("/testWebhook/JAVA")
            .header(HttpHeaders.AUTHORIZATION, webhookResponse.getAccessToken())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(solution)
            .retrieve()
            .bodyToMono(String.class)
            .doOnSuccess(response -> log.info("Solution submitted successfully! Response: {}", response))
            .doOnError(error -> log.error("Error submitting solution: ", error))
            .subscribe();
    }
}