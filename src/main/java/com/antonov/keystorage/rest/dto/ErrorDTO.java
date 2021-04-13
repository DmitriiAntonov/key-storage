package com.antonov.keystorage.rest.dto;

import lombok.Getter;

@Getter
public class ErrorDTO {
    private final String message;

    public ErrorDTO(String message) {
        this.message = message;
    }
}
