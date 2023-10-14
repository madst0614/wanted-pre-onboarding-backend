package com.onboarding.recruit.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
	INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid Parameter Included"),
	ALREADY_APPLIED(HttpStatus.CONFLICT, "Already Applied"),
	BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "Board Not Exists"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

	private final HttpStatus httpStatus;
	private final String message;

}
