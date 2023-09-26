package com.github.alekseypetkun.t1_task.service;

/**
 * Сервис по работе с подсчетом и сортировкой символов в строке
 */
public interface CharCountService {

    /**
     * Получение количества символов в строке в убывающем порядке
     *
     * @param request вводимая строка пользователем
     * @return строка с количеством символов в убывающем порядке
     */
    String getCharCount(String request);
}
