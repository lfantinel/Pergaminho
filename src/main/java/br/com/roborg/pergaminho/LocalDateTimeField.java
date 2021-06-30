package br.com.roborg.pergaminho;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeField extends AbsLayoutField<LocalDateTime> {

    private final DateTimeFormatter formatter;

    public LocalDateTimeField(DateTimeFormatter formatter) {
        this.formatter = formatter;
        String sample = LocalDateTime.now().format(formatter);
        setSize(sample.length());
    }

    public LocalDateTimeField(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
        String sample = LocalDateTime.now().format(formatter);
        setSize(sample.length());
    }

    public LocalDateTimeField() {
        this("yyyyMMddHHmmss");
    }

    @Override
    protected LocalDateTime parseString(CharSequence text) {
        return LocalDateTime.parse(text, formatter);
    }

    @Override
    public String parseValue(LocalDateTime val) {
        return val.format(formatter);
    }
}

