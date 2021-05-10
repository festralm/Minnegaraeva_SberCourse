package ru.sbrf.school.java.homework.interfaces;

import java.util.Objects;
import java.util.function.Function;

public interface QuadFunction<F, S, T, L, R> {
    R apply(F f, S s, T t, L l);

    default <V> QuadFunction<F, S, T, L, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (F f, S s, T t, L l) -> after.apply(apply(f, s, t, l));
    }
}
