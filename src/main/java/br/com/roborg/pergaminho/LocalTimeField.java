package br.com.roborg.pergaminho;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeField extends AbsLayoutField<LocalTime> {

    private final DateTimeFormatter formatter;

    public LocalTimeField(DateTimeFormatter formatter) {
        this.formatter = formatter;
        String sample = LocalDateTime.now().format(formatter);
        setSize(sample.length());
    }

    public LocalTimeField(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
        String sample = LocalDateTime.now().format(formatter);
        setSize(sample.length());
    }

    public LocalTimeField() {
        this("HHmmss");
    }

    @Override
    protected LocalTime parseString(CharSequence text) {
        return LocalTime.parse(text, formatter);
    }

    @Override
    public String parseValue(LocalTime val) {
        return val.format(formatter);
    }
}

