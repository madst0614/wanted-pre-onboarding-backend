package com.onboarding.recruit.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 게시물이 존재하지 않습니다.");
	
	private final HttpStatus httpStatus;
    private final String message;

}
