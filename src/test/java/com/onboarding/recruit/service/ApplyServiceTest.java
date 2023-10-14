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

import com.onboarding.recruit.domain.ApplyVO;
import com.onboarding.recruit.domain.BoardVO;
import com.onboarding.recruit.dto.ApplyDTO;
import com.onboarding.recruit.dto.BoardDTO;
import com.onboarding.recruit.mapper.ApplyMapper;

@ExtendWith(MockitoExtension.class)
public class ApplyServiceTest {
	
	@Spy
	@InjectMocks
	private ApplyServiceImpl applyService;

	@Mock
	private ApplyMapper applyMapper;

	@Mock
	private ApplyDTO applyDTO;

	@Test
	@DisplayName("등록 테스트")
	public void testRegister() {
		// Given
		ApplyVO applyVO = ApplyVO.builder().bno(1).uid(1).build();

		when(applyDTO.toVO()).thenReturn(applyVO);
		when(applyMapper.insert(applyVO)).thenReturn(1);

		// When
		int result = applyService.register(applyDTO);

		// Then
		assertThat(result).isEqualTo(1);
	}

}
