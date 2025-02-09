package org.example.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String convertToDatabaseColumn(LocalDate localDate) {
        if(localDate == null){
            return null;
        }
        return localDate.format(formatter);
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbDate) {

        if(dbDate == null){
            return null;
        }

        return LocalDate.parse(dbDate, formatter);
    }
}
