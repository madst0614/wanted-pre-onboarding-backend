package com.onboarding.recruit.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.onboarding.recruit.domain.ApplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Log4j2
public class ApplyMapperTests {
	
	@Setter(onMethod_ = { @Autowired })
	private ApplyMapper mapper;

	@Test
	@DisplayName("삽입 테스트")
	public void testInsert() {
		log.info("---------삽입 테스트---------");
		// Given
		ApplyVO applyVO = ApplyVO.builder().bno(35).uid(1).build();

		// When
		mapper.insert(applyVO);

		// Then
		ApplyVO result = mapper.getApply(applyVO);
		log.info("삽입 테스트 결과 " + result);
		assertThat(result).isNotNull().extracting("bno").isEqualTo(35);
		assertThat(result).isNotNull().extracting("uid").isEqualTo(1);
	}
	
	@Test
	@DisplayName("지원 내역 가져오기")
	public void testGetApply() {
		log.info("---------지원 내역 가져오기 테스트---------");
		// Given
		ApplyVO applyVO= ApplyVO.builder().bno(35).uid(1).build();
		mapper.insert(applyVO);

		// when
		ApplyVO result = mapper.getApply(applyVO);

		// then
		assertThat(result.getBno()).isEqualTo(applyVO.getBno());
		assertThat(result.getUid()).isEqualTo(applyVO.getUid());

	}
}
