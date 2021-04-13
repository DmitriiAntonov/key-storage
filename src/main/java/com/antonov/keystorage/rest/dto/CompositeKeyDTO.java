package com.antonov.keystorage.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

@Getter
public class CompositeKeyDTO {

    @Valid
    @NotEmpty
    private final List<KeyDTO> keys;

    @JsonCreator(mode = PROPERTIES)
    public CompositeKeyDTO(
            @JsonProperty("keys") List<KeyDTO> keys
    ) {
        this.keys = keys;
    }
}
