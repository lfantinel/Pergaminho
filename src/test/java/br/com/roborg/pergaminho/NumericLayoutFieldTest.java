package br.com.roborg.pergaminho;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumericLayoutFieldTest {

    String INT_STRING = "0000000010";
    String DEC_STRING = "0000010100";
    String P_INT_STRING = "+000000010";
    String N_INT_STRING = "-000000010";
    String DEC_STRING_P = "000010100+";
    String DEC_STRING_N = "000010100-";

    Integer P_INT_VALUE = 10;
    Double P_DEC_VALUE = 10.100D;
    Integer N_INT_VALUE = -10;
    Double N_DEC_VALUE = -10.100D;

    @Test
    public void numericLayoutWithoutDecimalWriteTest(){
        NumericField field = new NumericField(10);
        field.value(10.1);
        String text = field.toString();
        assertEquals(INT_STRING, text);
    }

    @Test
    public void numericLayoutWithDecimalWriteTest(){
        NumericField field = new NumericField(10,3);
        field.value(10.1);
        String text = field.toString();
        assertEquals(DEC_STRING, text);
    }

    @Test
    public void numericLayoutWithoutDecimalReadTest(){
        NumericField field = new NumericField(10);
        Number n = field.fromString(INT_STRING);
        assertEquals(P_INT_VALUE, n.intValue());
    }

    @Test
    public void numericLayoutWithDecimalReadTest(){
        NumericField field = new NumericField(10,3);
        Number n = field.fromString(DEC_STRING);
        assertEquals(P_DEC_VALUE, n.doubleValue());
    }

    @Test
    public void numericLayoutPatterWriteTest(){
        NumericField field = new NumericField("0000000000");
        field.value(10.1);
        assertEquals(10, field.size(), "Size");
        assertEquals(0, field.precision(), "Precision");
        assertEquals(INT_STRING, field.toString(), "Integer");

        field = new NumericField("+000000000;-#");
        field.value(10.1);
        assertEquals(10, field.size(), "Size");
        assertEquals(0, field.precision(), "Precision");
        assertEquals(P_INT_STRING, field.toString(), "+ Integer");

        field = new NumericField("+000000000;-#");
        field.value(-10.1);
        assertEquals(10, field.size(), "Size");
        assertEquals(0, field.precision(), "Precision");
        assertEquals(N_INT_STRING, field.toString(), "- Integer");

        field = new NumericField("0000000.000");
        field.value(10.1);
        assertEquals(10, field.size(), "Size");
        assertEquals(3, field.precision(), "Precision");
        assertEquals(DEC_STRING, field.toString(), "Decimal");

        field = new NumericField("000000.000+;#-");
        field.value(10.1);
        assertEquals(10, field.size(), "Size");
        assertEquals(3, field.precision(), "Precision");
        assertEquals(DEC_STRING_P, field.toString(), "Decimal +");

        field = new NumericField("000000.000+;#-");
        field.value(-10.1);
        assertEquals(10, field.size(), "Size");
        assertEquals(3, field.precision(), "Precision");
        assertEquals(DEC_STRING_N, field.toString(), "Decimal -");
    }

    @Test
    public void numericLayoutPatterReadTest(){
        NumericField field = new NumericField("0000000000");
        Number n = field.fromString(INT_STRING);
        assertEquals(P_INT_VALUE, n.intValue(), "Integer");

        field = new NumericField("+000000000;-#");
        n = field.fromString(P_INT_STRING);
        assertEquals(P_INT_VALUE, n.intValue(), "+ Integer");

        field = new NumericField("+000000000;-#");
        n = field.fromString(N_INT_STRING);
        assertEquals(N_INT_VALUE, n.intValue(), "- Integer");

        field = new NumericField("0000000.000");
        n = field.fromString(DEC_STRING);
        assertEquals(P_DEC_VALUE, n.doubleValue(), "Decimal");

        field = new NumericField("000000.000+;#-");
        n = field.fromString(DEC_STRING_P);
        assertEquals(P_DEC_VALUE, n.doubleValue(), "Decimal +");

        field = new NumericField("000000.000+;#-");
        n = field.fromString(DEC_STRING_N);
        assertEquals(N_DEC_VALUE, n.doubleValue(), "Decimal -");
    }

}
