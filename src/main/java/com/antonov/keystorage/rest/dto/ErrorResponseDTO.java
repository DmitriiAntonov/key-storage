package com.antonov.keystorage.rest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class ErrorResponseDTO<T> {

    private final List<T> errors;
}
