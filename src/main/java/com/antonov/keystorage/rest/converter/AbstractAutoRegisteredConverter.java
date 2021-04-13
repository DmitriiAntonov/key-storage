package com.antonov.keystorage.rest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import javax.annotation.PostConstruct;

public abstract class AbstractAutoRegisteredConverter<S, T> implements Converter<S, T> {

    private ConversionService conversionService;

    public ConversionService getConversionService() {
        return conversionService;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @SuppressWarnings("unused")
    @PostConstruct
    private void register() {
        if (conversionService instanceof GenericConversionService) {
            ((GenericConversionService) conversionService).addConverter(this);
        } else {
            throw new IllegalStateException("Can't register Converter to ConverterRegistry");
        }
    }
}
