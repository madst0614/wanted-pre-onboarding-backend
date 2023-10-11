package com.onboarding.recruit.service;

import java.util.List;

import com.onboarding.recruit.domain.BoardVO;
import com.onboarding.recruit.dto.BoardDTO;

public interface BoardService {
	
	public int register(BoardDTO boardDTO);
	
	public int modify(BoardDTO boardDTO);
	
	public int remove(BoardDTO boardDTO);
	
	public List<BoardDTO> getAllBoardList(String keyword);
	
	public BoardDTO getBoardDetail(BoardDTO boardDTO);
}
