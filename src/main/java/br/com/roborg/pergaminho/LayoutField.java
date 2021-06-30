package br.com.roborg.pergaminho;

import java.util.function.Function;

public interface LayoutField<T> {
    String toString();
    T fromString(CharSequence value);
}
