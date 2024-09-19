package com.workintech.s18d4.exceptions;

import org.springframework.http.HttpStatus;

public record AccountResponse(String message, HttpStatus httpStatus) {
}
