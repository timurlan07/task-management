package com.example.taskmanagement.model.dto;

import lombok.Builder;

@Builder
public record TaskRequest(String description,
                          boolean done) {
}
