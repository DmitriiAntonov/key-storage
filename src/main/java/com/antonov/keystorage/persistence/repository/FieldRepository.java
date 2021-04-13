package com.antonov.keystorage.persistence.repository;

import com.antonov.keystorage.persistence.entity.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<FieldEntity, Long> {
}
