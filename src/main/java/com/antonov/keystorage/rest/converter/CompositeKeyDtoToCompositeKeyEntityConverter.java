package com.antonov.keystorage.rest.converter;

import com.antonov.keystorage.persistence.entity.CompositeKeyEntity;
import com.antonov.keystorage.persistence.entity.FieldEntity;
import com.antonov.keystorage.rest.dto.CompositeKeyDTO;
import com.antonov.keystorage.rest.dto.FieldDTO;
import com.antonov.keystorage.rest.dto.KeyDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompositeKeyDtoToCompositeKeyEntityConverter extends AbstractAutoRegisteredConverter<CompositeKeyDTO, CompositeKeyEntity> {

    @Override
    public CompositeKeyEntity convert(CompositeKeyDTO source) {
        CompositeKeyEntity compositeKey = new CompositeKeyEntity();

        List<FieldEntity> fields = getFields(source);

        fields.forEach(field -> field.setCompositeKey(compositeKey));

        compositeKey.fields.addAll(fields);

        return compositeKey;
    }

    private List<FieldEntity> getFields(final CompositeKeyDTO source) {
        return source.getKeys()
                .stream()
                .map(this::createFields)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<FieldEntity> createFields(KeyDTO key) {
        return key.getFields()
                .stream()
                .map(field -> createField(key, field))
                .collect(Collectors.toList());
    }

    private FieldEntity createField(KeyDTO key, FieldDTO field) {
        final var convertedField = getConversionService().convert(field, FieldEntity.class);

        convertedField.setKey(key.getName());

        return convertedField;
    }
}
