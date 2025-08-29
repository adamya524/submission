package com.bfh.submission.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebhookResponse {
    @JsonProperty("webhookURL")
    private String webhookURL;

    @JsonProperty("accessToken")
    private String accessToken;
}

