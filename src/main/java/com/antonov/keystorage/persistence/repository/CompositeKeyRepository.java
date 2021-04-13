package com.antonov.keystorage.persistence.repository;

import com.antonov.keystorage.persistence.entity.CompositeKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositeKeyRepository extends JpaRepository<CompositeKeyEntity, Long> {
}
