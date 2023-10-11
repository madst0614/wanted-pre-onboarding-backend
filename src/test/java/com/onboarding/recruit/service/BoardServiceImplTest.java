package com.onboarding.recruit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onboarding.recruit.domain.BoardVO;
import com.onboarding.recruit.dto.BoardDTO;
import com.onboarding.recruit.mapper.BoardMapper;

@ExtendWith(MockitoExtension.class)
public class BoardServiceImplTest {

	@Spy
	@InjectMocks
	private BoardServiceImpl boardService;

	@Mock
	private BoardMapper boardMapper;

	@Mock
	private BoardDTO boardDTO;

	@Test
	@DisplayName("등록 테스트")
	public void testRegister() {
		// Given
		BoardVO boardVO = BoardVO.builder().cid(1).cName("원티드").position("자바 개발자").content("삽입").build();

		when(boardDTO.toVO()).thenReturn(boardVO);
		when(boardMapper.insert(boardVO)).thenReturn(1);

		// When
		int result = boardService.register(boardDTO);

		// Then
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("수정 테스트")
	public void testModify() {
		// Given
		BoardVO beforeBoardVO = BoardVO.builder().bno(1).cid(1).cName("원티드").position("자바 개발자").content("수정 전").build();
		BoardVO afterBoardVO = BoardVO.builder().bno(1).cid(1).cName("원티드").position("자바 개발자").content("수정 후").build();

		when(boardMapper.getBoardByBno(boardDTO.getBno())).thenReturn(beforeBoardVO);
		when(boardDTO.toVO()).thenReturn(afterBoardVO);
		when(boardMapper.update(afterBoardVO)).thenReturn(1);

		// When
		int result = boardService.modify(boardDTO);

		// Then
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("삭제 테스트")
	public void testRemove() {
		// Given
		BoardDTO boardDTO = BoardDTO.builder().bno(1).cid(1).cName("원티드").position("자바 개발자").content("삭제").build();
		BoardVO boardVO = BoardVO.builder().bno(1).cid(1).cName("원티드").position("자바 개발자").content("삭제").build();

		when(boardMapper.getBoardByBno(boardDTO.getBno())).thenReturn(boardVO);
		when(boardMapper.delete(boardVO.getBno())).thenReturn(1);

		// When
		int result = boardService.remove(boardDTO);

		// Then
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("모든 공고 가져오기 테스트")
	public void testGetAllBoardList() {
		// Given
		List<BoardVO> voList = new ArrayList<BoardVO>();
		voList.add(BoardVO.builder().bno(0).cid(0).cName("원티드").position("자바 개발자").content("모든 공고").build());
		voList.add(BoardVO.builder().bno(1).cid(1).cName("원티드").position("자바 개발자").content("모든 공고").build());
		voList.add(BoardVO.builder().bno(2).cid(2).cName("원티드").position("자바 개발자").content("모든 공고").build());

		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		voList.forEach(vo -> dtoList.add(new BoardDTO(vo, null)));
		when(boardMapper.getAllBoardList("자바")).thenReturn(voList);

		// When
		List<BoardDTO> result = boardService.getAllBoardList("자바");

		// Then
		for (int i = 0; i < 3; i++) {
			assertThat(result.get(i).getBno()).isEqualTo(i);
		}

	}

	@Test
	@DisplayName("공고 디테일 가져오기 테스트")
	public void testGetBoardDetail() {
		// Given
		BoardDTO boardDTO = BoardDTO.builder().bno(0).cid(1).cName("원티드").position("자바 개발자").content("원티드 공고").build();
		List<BoardVO> voList = new ArrayList<BoardVO>();
		voList.add(BoardVO.builder().bno(0).cid(1).cName("원티드").position("자바 개발자").content("원티드 공고").build());
		voList.add(BoardVO.builder().bno(1).cid(1).cName("원티드").position("자바 개발자").content("원티드 공고").build());
		voList.add(BoardVO.builder().bno(2).cid(1).cName("원티드").position("자바 개발자").content("원티드 공고").build());

		when(boardMapper.getBoardDetail(1)).thenReturn(voList);

		// When
		BoardDTO result = boardService.getBoardDetail(boardDTO);

		// Then
		assertThat(result.getBno()).isEqualTo(0);
		assertThat(result.getCid()).isEqualTo(1);
	}
}
