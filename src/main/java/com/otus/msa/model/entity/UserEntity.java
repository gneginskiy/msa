package com.otus.msa.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

import static com.otus.msa.model.entity.generator.AbsentUUIDGenerator.ABSENT;
import static com.otus.msa.model.entity.generator.AbsentUUIDGenerator.UUID_GENERATOR_CLASSIFIER;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ABSENT)
    @GenericGenerator(name = ABSENT, strategy = UUID_GENERATOR_CLASSIFIER)
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
