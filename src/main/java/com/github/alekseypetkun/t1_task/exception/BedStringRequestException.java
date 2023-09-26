package com.github.alekseypetkun.t1_task.exception;

public class BedStringRequestException extends RuntimeException {

    public BedStringRequestException(String message) {
        super("Введенная строка: " + message + " содержит небуквенные символы!");
    }
}
