package com.antonov.keystorage.service;

import com.antonov.keystorage.persistence.entity.CompositeKeyEntity;
import com.antonov.keystorage.persistence.repository.CompositeKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompositeKeyService {

    private final CompositeKeyRepository compositeKeyRepository;

    @Transactional
    public List<CompositeKeyEntity> saveAll(final List<CompositeKeyEntity> compositeKeys) {
        return compositeKeyRepository.saveAll(compositeKeys);
    }
}
