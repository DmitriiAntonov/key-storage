package com.antonov.keystorage.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
public final class CompositeKeyRequestDTO {

    @Valid
    @NotEmpty
    private final List<CompositeKeyDTO> compositeKeys;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CompositeKeyRequestDTO(final List<CompositeKeyDTO> compositeKeys) {
        this.compositeKeys = compositeKeys;
    }
}
