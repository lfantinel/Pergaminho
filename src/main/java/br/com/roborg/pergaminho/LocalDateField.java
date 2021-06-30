package br.com.roborg.pergaminho;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateField extends AbsLayoutField<LocalDate> {

    private final DateTimeFormatter formatter;

    public LocalDateField(DateTimeFormatter formatter) {
        this.formatter = formatter;
        String sample = LocalDateTime.now().format(formatter);
        setSize(sample.length());
    }

    public LocalDateField(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
        String sample = LocalDateTime.now().format(formatter);
        setSize(sample.length());
    }

    public LocalDateField() {
        this("yyyyMMdd");
    }

    @Override
    protected LocalDate parseString(CharSequence text) {
        return LocalDate.parse(text, formatter);
    }

    @Override
    public String parseValue(LocalDate val) {
        return val.format(formatter);
    }
}

