package tr.salkan.code.java.genericApi.generic.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tr.salkan.code.java.genericApi.generic.enums.GenericPersistableEnum;

@Converter
public class GenericEnumConverter<T extends Enum<T> & GenericPersistableEnum<E>, E> implements AttributeConverter<T, E> {

    private final Class<T> clazz;

    public GenericEnumConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E convertToDatabaseColumn(T attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        if (dbData == null) {
            return null;
        }
        T[] enums = clazz.getEnumConstants();

        for (T e : enums) {
            if (e.getValue().equals(dbData)) {
                return e;
            }
        }
        throw new UnsupportedOperationException();
    }
}