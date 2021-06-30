package br.com.roborg.pergaminho;

import br.com.roborg.pergaminho.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static br.com.roborg.pergaminho.TextField.Case.NORMAL;

@Getter
@AllArgsConstructor
public class TextField extends AbsLayoutField<CharSequence> {

    public enum Pad {
        LPAD, RPAD;
    }

    public enum Case {
        NORMAL, UPPER, LOWER;
    }

    private Pad pad;
    private char character;
    private Case mCase = NORMAL;

    public TextField (Integer size) {
        super(size);
    }

    public TextField (Integer size, Pad pad, char character) {
        super(size);
        this.pad = pad;
        this.character = character;
    }

    public TextField(Integer size, Pad pad, char character, Case mCase) {
        super(size);
        this.pad = pad;
        this.character = character;
        this.mCase = mCase;
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
        } else if (pad != null) {
            result =  Pad.LPAD.equals(pad)
                    ? StringUtil.lpad(value(),size(),character)
                    : StringUtil.rpad(value(),size(),character);
        }
        switch (mCase) {
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

