package com.antonov.keystorage.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "composite_key")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
public class CompositeKeyEntity {

    private static final String GENERATOR_NAME = "compositeKeyGenerator";
    private static final String SEQUENCE_NAME = "composite_key_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    public Long id;

    @NotEmpty
    @OneToMany(mappedBy = "compositeKey", cascade = { PERSIST, MERGE })
    public List<FieldEntity> fields = new ArrayList<>();
}
