package br.com.roborg.pergaminho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Deprecated
public class DateField extends AbsLayoutField<Date> {

    private final SimpleDateFormat formatter;

    public DateField(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
        String sample = formatter.format(new Date());
        setSize(sample.length());
    }

    public DateField() {
        this("yyyyMMddHHmmss");
    }

    @Override
    protected Date parseString(CharSequence text) {
        try {
            return formatter.parse(text.toString());
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public String parseValue(Date val) {
        return formatter.format(val);
    }
}

