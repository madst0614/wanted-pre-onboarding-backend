package com.onboarding.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.onboarding.recruit.domain.BoardVO;

@Mapper
public interface BoardMapper {
	
	public int insert(BoardVO board);
	
	public BoardVO getBoardByBno(int bno);
	
	public int delete(int bno);
	
	public int update(BoardVO board);
	
	public List<Integer> getAnotherBoard(int cid);
	
	public List<BoardVO> getBoardList(String keyword);
}
