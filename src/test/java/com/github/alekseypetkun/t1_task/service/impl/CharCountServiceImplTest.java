package com.github.alekseypetkun.t1_task.service.impl;

import com.github.alekseypetkun.t1_task.exception.BedStringRequestException;
import com.github.alekseypetkun.t1_task.service.CharCountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharCountServiceImplTest {

    private final CharCountService charCountService = new CharCountServiceImpl();

    @Test
    public void testGetCharCount() {
        String request = "helloWorld";
        String response = "l: 3, o: 2, r: 1, d: 1, e: 1, W: 1, h: 1";
        assertEquals(response, charCountService.getCharCount(request));
    }

    @Test
    public void testGetCharCountWithInvalidChars() {
        String request = "hello world";
        assertThrows(BedStringRequestException.class, () -> charCountService.getCharCount(request));
    }
}