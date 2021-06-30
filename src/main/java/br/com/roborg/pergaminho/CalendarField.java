package br.com.roborg.pergaminho;

import br.com.roborg.pergaminho.util.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CalendarField extends AbsLayoutField<Calendar> {

    private final SimpleDateFormat formatter;

    public CalendarField(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
        String sample = formatter.format(Calendar.getInstance().getTime());
        setSize(sample.length());
    }

    public CalendarField() {
        this("yyyyMMddHHmmss");
    }

    @Override
    protected Calendar parseString(CharSequence text) {
        try {
            Calendar date = Calendar.getInstance();
            Date time = formatter.parse(text.toString());
            date.setTime(time);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public String parseValue(Calendar val) {
        return formatter.format(val.getTime());
    }
}

