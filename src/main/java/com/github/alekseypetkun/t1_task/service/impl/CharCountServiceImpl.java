package com.github.alekseypetkun.t1_task.service.impl;

import com.github.alekseypetkun.t1_task.exception.BedStringRequestException;
import com.github.alekseypetkun.t1_task.service.CharCountService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Map<Character, Integer> map = new HashMap<>();

        char[] arrayChar = request.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : arrayChar) {

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Map.Entry<Character, Integer>> sortedMap = new ArrayList<>(map.entrySet());
        sortedMap.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int sum = 0;
        for (Map.Entry<Character, Integer> entry : sortedMap) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue());
            sum++;
            if (sortedMap.size() != sum) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
