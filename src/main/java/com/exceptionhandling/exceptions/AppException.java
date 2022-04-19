package com.exceptionhandling.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppException {
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime localDateTime;
}
