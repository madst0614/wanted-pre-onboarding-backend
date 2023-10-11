package com.onboarding.recruit.mapper;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.onboarding.recruit.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Log4j2
public class BoardMapperTests {

	@Setter(onMethod_ = { @Autowired })
	public BoardMapper mapper;

	@Test
	@DisplayName("삽입 테스트")
	public void testInsert() {
		log.info("---------삽입 테스트---------");
		// Given
		BoardVO board = BoardVO.builder().position("개발자").cid(1).build();

		// When
		log.info("insert " + board);
		mapper.insert(board);
		log.info(board);

		// Then
		log.info("삽입 테스트 결과 " + mapper.getBoardByBno(board.getBno()));
	}

	@Test
	@DisplayName("삭제 테스트")
	public void testDelete() {
		log.info("---------삭제 테스트---------");

		// Given
		BoardVO board = BoardVO.builder().position("삭제용").cid(1).content("삭제용입니다").build();
		mapper.insert(board);
		log.info("delete this" + mapper.getBoardByBno(board.getBno()));
		// When
		mapper.delete(board.getBno());

		// Then
		log.info("삭제 테스트 결과 " + mapper.getBoardByBno(board.getBno()));
	}

	@Test
	@DisplayName("채용 회사 공고들 가져오기 테스트")
	public void testGetList() {
		log.info("---------채용 회사 공고들 가져오기 테스트---------");
		// Given
		for (int i = 0; i < 10; i++) {
			mapper.insert(BoardVO.builder().position("회사채용개발자" + i).cid(1).build());
		}

		// When
		List<BoardVO> boardList = mapper.getBoardDetail(1);

		// Then
		log.info("채용 회사 공고들 가져오기 테스트 결과 ");
		boardList.forEach(board -> log.info(board));
	}

	@Test
	@DisplayName("모든 공고 리스트 가져오기 테스트")
	public void testGetALLList() {
		log.info("---------모든 공고 리스트 가져오기 테스트---------");

		// Given

		// When
		List<BoardVO> boardList = mapper.getAllBoardList("자바");

		// Then
		log.info("모든 공고 리스트 가져오기 테스트");
		boardList.forEach(board -> log.info(board));
	}

	@Test
	@DisplayName("업데이트 테스트")
	public void testUpdate() {
		log.info("---------업데이트 테스트---------");

		// Given
		BoardVO board = BoardVO.builder().position("업데이트 개발자").cid(1).content("수정 전").build();
		mapper.insert(board);
		log.info(board);

		// When
		board.setContent("수정 후");
		mapper.update(board);

		// Then
		log.info("업데이트 테스트 결과 " + mapper.getBoardByBno(board.getBno()));
	}
}