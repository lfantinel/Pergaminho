package br.com.roborg.pergaminho;

import lombok.*;
import lombok.experimental.Accessors;


@Accessors(fluent = true)
@RequiredArgsConstructor
abstract class AbsLayoutField<T> implements LayoutField<T> {

    @Getter @Setter
    private T value;

    @Getter
    private final int size;

    protected AbsLayoutField() {
        this.size = 0;
    }

    @Override
    public final String toString() {
        return parseValue(value);
    }

    @Override
    public final T fromString(CharSequence text) {
        this.value = parseString(text);
        return value;
    }

    protected abstract T parseString(CharSequence text);
    protected abstract String parseValue(T value);
}
