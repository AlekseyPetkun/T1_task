package com.github.alekseypetkun.t1_task.service.impl;

import com.github.alekseypetkun.t1_task.exception.BedStringRequestException;
import com.github.alekseypetkun.t1_task.service.CharCountService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Бизнес-логика по работе с подсчетом и сортировкой символов в строке
 */
@Service
public class CharCountServiceImpl implements CharCountService {

    private static final Pattern PATTERN = Pattern
            .compile("^[a-zA-Zа-яА-Я]+$");

    @Override
    public String getCharCount(String request) {

        Matcher matcher = PATTERN.matcher(request);
        if (!matcher.find()) {
            throw new BedStringRequestException(request);
        }

        String result = Arrays.stream(request.split(""))
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                                map -> map.entrySet().stream()
                                        .sorted((o1, o2) -> o2.getValue().intValue() - o1.getValue().intValue())
                                        .map(entry -> String.join(": ", entry.getKey(), entry.getValue().toString()))
                                        .collect(Collectors.joining(", "))
                        )
                );

        return result;
    }
}
