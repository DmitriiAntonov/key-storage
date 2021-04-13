package com.antonov.keystorage.rest.dto;

import lombok.Getter;

@Getter
public final class ValidationErrorDTO extends ErrorDTO {
    private final String field;
    private final Object rejectedValue;

    public ValidationErrorDTO(
            String message,
            String field,
            Object rejectedValue
    ) {
        super(message);
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
}
