package com.onboarding.recruit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onboarding.recruit.dto.ApplyDTO;
import com.onboarding.recruit.service.ApplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/apply")
@AllArgsConstructor
@Log4j2
public class ApplyController {
	private ApplyService applyService;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public String register(@RequestBody ApplyDTO applyDTO) {
		log.info("<BoardController> register" + applyDTO);

		applyService.register(applyDTO);

		return"Success";
	}
}
