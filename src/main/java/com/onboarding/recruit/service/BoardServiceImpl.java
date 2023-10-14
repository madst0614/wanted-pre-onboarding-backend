package com.onboarding.recruit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboarding.recruit.domain.BoardVO;
import com.onboarding.recruit.dto.BoardDTO;
import com.onboarding.recruit.exception.CommonErrorCode;
import com.onboarding.recruit.exception.CustomException;
import com.onboarding.recruit.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Transactional
	@Override
	public int register(BoardDTO boardDTO) {
		log.info("<Board Service> register " + boardDTO);
		BoardVO boardVO = boardDTO.toVO();
		log.info("<Board Service> DTO TO VO " + boardVO);

		return mapper.insert(boardVO);
	}

	@Transactional
	@Override
	public int modify(BoardDTO boardDTO) {
		log.info("<Board Service> modify " + boardDTO);
		BoardVO board = mapper.getBoardByBno(boardDTO.getBno());

		if (board == null)
			throw new CustomException(CommonErrorCode.BOARD_NOT_FOUND);

		log.info("<Board Service> before Modify " + board);
		BoardVO boardVO = boardDTO.toVO();
		log.info("<Board Service> DTO TO VO " + boardVO);

		return mapper.update(boardVO);
	}

	@Transactional
	@Override
	public int remove(int bno) {
		log.info("<Board Service> remove " + bno);

		BoardVO board = mapper.getBoardByBno(bno);

		if (board == null)
			throw new CustomException(CommonErrorCode.BOARD_NOT_FOUND);

		return mapper.delete(bno);
	}

	@Transactional
	@Override
	public List<BoardDTO> getAllBoardList(String keyword) {
		log.info("<Board Service> getAllBoardList with " + keyword);

		List<BoardDTO> allBoardList = new ArrayList<BoardDTO>();

		List<BoardVO> voList = mapper.getAllBoardList(keyword);

		voList.forEach(vo -> allBoardList.add(new BoardDTO(vo, null)));

		return allBoardList;
	}

	@Transactional
	@Override
	public BoardDTO getBoardDetail(int bno) {
		log.info("<Board Service> getBoardDetail bno is " + bno);
		BoardVO boardVO = mapper.getBoardByBno(bno);
		if (boardVO == null)
			throw new CustomException(CommonErrorCode.BOARD_NOT_FOUND);

		List<BoardVO> boardList = mapper.getBoardDetail(boardVO.getCid());
		boardVO = null;
		List<Integer> companyBoardList = new ArrayList<Integer>();

		for (BoardVO vo : boardList) {
			if (vo.getBno() != bno) {
				companyBoardList.add(vo.getBno());
			} else {
				boardVO = vo;
			}
		}

		if (boardVO == null)
			throw new CustomException(CommonErrorCode.BOARD_NOT_FOUND);

		return new BoardDTO(boardVO, companyBoardList);
	}
}
