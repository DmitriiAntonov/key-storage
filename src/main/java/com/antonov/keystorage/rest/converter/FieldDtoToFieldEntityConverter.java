package com.antonov.keystorage.rest.converter;

import com.antonov.keystorage.persistence.entity.FieldEntity;
import com.antonov.keystorage.rest.dto.FieldDTO;
import org.springframework.stereotype.Component;

@Component
public class FieldDtoToFieldEntityConverter extends AbstractAutoRegisteredConverter<FieldDTO, FieldEntity> {

    @Override
    public FieldEntity convert(FieldDTO source) {
        FieldEntity target = new FieldEntity();

        target.setName(source.getName());
        target.setIsKey(source.getIsKey());
        target.setValue(source.getValue());

        return target;
    }
}
