package com.antonov.keystorage.rest.controller;

import com.antonov.keystorage.persistence.entity.CompositeKeyEntity;
import com.antonov.keystorage.rest.dto.CompositeKeyDTO;
import com.antonov.keystorage.rest.dto.CompositeKeyRequestDTO;
import com.antonov.keystorage.service.CompositeKeyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/composite-keys")
@RequiredArgsConstructor
public class CompositeKeyRestController {

    private final CompositeKeyService compositeKeyService;
    private final ConversionService conversionService;

    @PostMapping
    @ApiOperation("Сохранение компазитных ключей")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAll(@Valid @RequestBody CompositeKeyRequestDTO request) {
        List<CompositeKeyEntity> compositeKeys = request
                .getCompositeKeys()
                .stream()
                .map(compositeKey -> conversionService.convert(compositeKey, CompositeKeyEntity.class))
                .collect(Collectors.toList());

        compositeKeyService.saveAll(compositeKeys);
    }
}
