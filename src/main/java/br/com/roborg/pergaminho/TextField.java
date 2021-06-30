package br.com.roborg.pergaminho;

import br.com.roborg.pergaminho.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static br.com.roborg.pergaminho.TextField.Case.NORMAL;

@Getter
@AllArgsConstructor
public class TextField extends AbsLayoutField<CharSequence> {

    public enum Pad {
        LPAD, RPAD
    }

    public enum Case {
        NORMAL, UPPER, LOWER
    }

    private Pad padType;
    private char padChar;
    private Case caseType = NORMAL;

    public TextField (Integer size) {
        super(size);
    }

    public TextField (Integer size, Pad padType, char padChar) {
        super(size);
        this.padType = padType;
        this.padChar = padChar;
    }

    public TextField(Integer size, Pad padType, char padChar, Case caseType) {
        super(size);
        this.padType = padType;
        this.padChar = padChar;
        this.caseType = caseType;
    }

    @Override
    protected CharSequence parseString(CharSequence text) {
        return text.toString().trim();
    }

    @Override
    public String parseValue(CharSequence val) {
        CharSequence result = value();
        if (result.length() >= size()) {
            result = result.toString().substring(0, size());
        } else if (padType != null) {
            result =  Pad.LPAD.equals(padType)
                    ? StringUtil.lpad(value(),size(), padChar)
                    : StringUtil.rpad(value(),size(), padChar);
        }
        switch (caseType) {
            case UPPER:
                return result.toString().toUpperCase();
            case LOWER:
                return result.toString().toLowerCase();
            default:
            case NORMAL:
                return result.toString();
        }
    }
}

