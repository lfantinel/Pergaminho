package br.com.roborg.pergaminho;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

import java.text.DecimalFormat;

import static br.com.roborg.pergaminho.util.StringUtil.rpad;
import static java.util.Locale.US;

@Accessors(fluent = true)
public class NumericField extends AbsLayoutField<Number> {

    @Getter
    private Integer precision = 0;
    private DecimalFormat mDf;

    public NumericField(Integer size) {
        super(size);
    }

    public NumericField(Integer size, Integer precision) {
        super(size);
        this.precision = precision;
    }

    public NumericField(String pattern) {
        this(config(pattern)[0], config(pattern)[1]);
        this.mDf = getUsFormatter(pattern);
    }

    private static int[] config(String pattern) {
        DecimalFormat df = getUsFormatter(pattern);
        String sample = df.format(1.0);
        int size = sample.replaceAll("\\.", "").length();
        String[] parts = sample.split("(\\.)|([+-]$)");
        int precision = (parts.length > 1 )
                ? parts[1].length()
                : 0;
        return new int[]{size, precision};
    };

    @Override
    @SneakyThrows
    public Number parseString(CharSequence value) {
        String s = value.toString();
        if (precision() > 0) {
            int ff = (s.endsWith("+") || s.endsWith("-")) ? 1 : 0;
            String intPart = s.substring(0,size()-precision()-ff);
            String decPart = s.substring(size()-precision()-ff);
            String full = (intPart+"."+decPart);
            Number ret = getFormatter().parse(full).doubleValue();
            return ret;
        } else {
            return getFormatter().parse(value.toString());
        }
    }

    private static DecimalFormat getUsFormatter(String pattern) {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(US);
        df.applyPattern(pattern);
        return df;
    }

    private DecimalFormat getFormatter() {
        if (mDf == null) {
            String  intPart = rpad("", size() - precision, '0');
            String decPart = (precision > 0) ? rpad(".", precision + 1, '0') : "";
            this.mDf = getUsFormatter(intPart+decPart);
        }
        return mDf;
    }

    public String parseValue(Number value) {
        return getFormatter().format(value()).replaceAll("\\.", "");
    }

}

