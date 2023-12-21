package com.otus.msa.model.entity.generator;

import lombok.SneakyThrows;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serializable;
import java.util.UUID;

import static com.otus.msa.util.Futility.ifNull;

//generates id before persisting entity, if it's not present.
public class AbsentUUIDGenerator extends SequenceStyleGenerator {
    public static final String UUID_GENERATOR_CLASSIFIER = "com.otus.msa.model.entity.generator.AbsentUUIDGenerator";
    public static final String ABSENT = "absent";
    public static final String ID_FIELDNAME = "id";

    @SneakyThrows
    @Override //todo: WHAT IF WE DON"T NEED THIS:????????!?!??
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        return ifNull((UUID)FieldUtils.readField(obj, ID_FIELDNAME, true), UUID::randomUUID);
    }
}