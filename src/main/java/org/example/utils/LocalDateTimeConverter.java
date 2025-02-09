package org.example.utils;

import jakarta.persistence.AttributeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        if(localDateTime == null){
            return null;
        }
        return localDateTime.format(formatter);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String s) {
        if(s == null){
            return null;
        }
        return LocalDateTime.parse(s, formatter);
    }
}
