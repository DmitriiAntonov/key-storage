package com.antonov.keystorage.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "field")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "isKey", "value"})
public class FieldEntity {

    private static final String GENERATOR_NAME = "fieldGenerator";
    private static final String SEQUENCE_NAME = "field_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    public Long id;

    @NotBlank
    @Column(name = "key")
    public String key;

    @NotBlank
    @Column(name = "name")
    public String name;

    @NotNull
    @Column(name = "is_key")
    public Boolean isKey;

    @NotBlank
    @Column(name = "value")
    public String value;

    @ManyToOne
    @JoinColumn(name = "composite_key_id")
    @NotNull
    public CompositeKeyEntity compositeKey;
}
