package com.github.alekseypetkun.t1_task.controller;

import com.github.alekseypetkun.t1_task.service.CharCountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер по работе с запросом строки и вывода количества символов в порядке убывания
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "API по работе с запросом в виде строки и вывода количества символов в порядке убывания")
public class Controller {

    private final CharCountService charCountService;
    @PostMapping
    @Operation(
            summary = "Получение строки с количеством символов в порядке убывания",
            description = "Нужно ввести валидную строку, которая должна состоять только из буквенных символов",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ответ получен (OK)",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = String.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ответ не получен, " +
                                    "т.к. не прошел валидацию (Bad Request)"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Произошла ошибка, не зависящая от вызывающей стороны"
                    )
            }
    )
    @ResponseStatus(HttpStatus.OK)
    public String getCharCount(@RequestParam("request") String request) {

        return charCountService.getCharCount(request);
    }
}
