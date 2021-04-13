package com.antonov.keystorage.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
public class KeyDTO {

    @NotBlank
    private final String name;

    @Valid
    @NotEmpty
    private final List<FieldDTO> fields;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public KeyDTO(
            @JsonProperty("name") String name,
            @JsonProperty("fields") List<FieldDTO> fields
    ) {
        this.name = name;
        this.fields = fields;
    }
}
