package br.com.roborg.pergaminho;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.JUNE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateLayoutFieldTest {

    private final static String CHK_DATETIME = "20210630133000";
    private final static String CHK_DATE = "20210630";
    private final static String CHK_TIME = "133000";

    @Test
    public void oldDateFieldTest(){
        final Date chkDate = new Date(2021-1900, JUNE,30,13,30,0);

        DateField field = new DateField();

        Date date = field.fromString(CHK_DATETIME);
        assertEquals(chkDate, date);
        assertEquals(CHK_DATETIME.length(), field.size());

        final String text = field.toString();
        assertEquals(CHK_DATETIME, text);
    }

    @Test
    public void calendarFieldTest(){
        final Calendar chkDate = Calendar.getInstance();
        chkDate.set(2021, JUNE, 30, 13,30,0);
        chkDate.set(Calendar.MILLISECOND, 0);

        CalendarField field = new CalendarField();

        Calendar date = field.fromString(CHK_DATETIME);
        assertEquals(chkDate, date);
        assertEquals(CHK_DATETIME.length(), field.size());

        final String text = field.toString();
        assertEquals(CHK_DATETIME, text);
    }

    @Test
    public void localDateTimeFieldTest(){
        final LocalDateTime chkDate = LocalDateTime.of(2021, 6, 30, 13,30,0,0);

        LocalDateTimeField field = new LocalDateTimeField();

        LocalDateTime date = field.fromString(CHK_DATETIME);
        assertEquals(chkDate, date);
        assertEquals(CHK_DATETIME.length(), field.size());

        final String text = field.toString();
        assertEquals(CHK_DATETIME, text);
    }

    @Test
    public void localDateFieldTest(){
        final LocalDate chkDate = LocalDate.of(2021, 6, 30);

        LocalDateField field = new LocalDateField();

        LocalDate date = field.fromString(CHK_DATE);
        assertEquals(chkDate, date);
        assertEquals(CHK_DATE.length(), field.size());

        final String text = field.toString();
        assertEquals(CHK_DATE, text);
    }

    @Test
    public void localTimeFieldTest(){
        final LocalTime chkDate = LocalTime.of(13,30,0,0);

        LocalTimeField field = new LocalTimeField();

        LocalTime date = field.fromString(CHK_TIME);
        assertEquals(chkDate, date);
        assertEquals(CHK_TIME.length(), field.size());

        final String text = field.toString();
        assertEquals(CHK_TIME, text);
    }
}
