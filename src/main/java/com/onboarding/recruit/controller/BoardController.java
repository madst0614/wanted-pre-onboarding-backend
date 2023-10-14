package com.onboarding.recruit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onboarding.recruit.dto.BoardDTO;
import com.onboarding.recruit.exception.CommonErrorCode;
import com.onboarding.recruit.exception.CustomException;
import com.onboarding.recruit.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
@Log4j2
public class BoardController {
	private BoardService boardService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<BoardDTO> getAllBoardList(
			@RequestParam(required = false, value = "keyword") String keyword) {
		log.info("<BoardController> getAllBoardList with " + keyword);

		return boardService.getAllBoardList(keyword);
	}

	@GetMapping("/{bno}")
	@ResponseStatus(HttpStatus.OK)
	public BoardDTO getBoardDetail(@PathVariable("bno") int bno) {
		log.info("<BoardController> getBoardDetail with " + bno);

		return boardService.getBoardDetail(bno);
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public String register(@RequestBody BoardDTO boardDTO) {
		log.info("<BoardController> register" + boardDTO);

		boolean result = boardService.register(boardDTO) == 1;

		if (!result)
			throw new CustomException(CommonErrorCode.INTERNAL_SERVER_ERROR);

		return "Success";
	}

	@PutMapping("/{bno}")
	@ResponseStatus(HttpStatus.OK)
	public String modify(@PathVariable("bno") int bno, @RequestBody BoardDTO boardDTO) {
		log.info("<BoardController> update" + boardDTO);
		
		boardDTO.setBno(bno);
		boolean result = boardService.modify(boardDTO) == 1;

		if (!result)
			throw new CustomException(CommonErrorCode.INTERNAL_SERVER_ERROR);

		return "Success";
	}

	@DeleteMapping("/{bno}")
	@ResponseStatus(HttpStatus.OK)
	public String remove(@PathVariable("bno") int bno) {
		log.info("<BoardController> delte" + bno);

		boolean result = boardService.remove(bno) == 1;

		if (!result)
			throw new CustomException(CommonErrorCode.INTERNAL_SERVER_ERROR);

		return "Success";
	}

}
