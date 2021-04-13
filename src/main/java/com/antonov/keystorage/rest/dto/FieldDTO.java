package com.antonov.keystorage.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class FieldDTO {

    @NotBlank
    private final String name;

    @NotNull
    private final Boolean isKey;

    @NotBlank
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public FieldDTO(
            @JsonProperty("name") String name,
            @JsonProperty("is_key") Boolean isKey,
            @JsonProperty("value") String value
    ) {
        this.name = name;
        this.isKey = isKey;
        this.value = value;
    }
}
