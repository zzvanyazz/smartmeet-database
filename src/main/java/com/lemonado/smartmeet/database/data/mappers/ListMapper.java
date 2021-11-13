package com.lemonado.smartmeet.database.data.mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListMapper {

    public static <T, R> List<T> mapList(Collection<R> list, Function<R, T> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T, R> Set<T> mapToSet(Collection<R> list, Function<R, T> mapper) {
        return list.stream().map(mapper).collect(Collectors.toSet());
    }

}
