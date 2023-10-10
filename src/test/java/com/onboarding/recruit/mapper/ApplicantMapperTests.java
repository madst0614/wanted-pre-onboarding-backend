package com.onboarding.recruit.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.onboarding.recruit.domain.ApplicantVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class ApplicantMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private ApplicantMapper mapper;

	@Test
	public void testInsert() {
		for (int i = 0; i < 10; i++) {
			//Given
			ApplicantVO applicant = ApplicantVO.builder().uname(i+"").build();
			log.info(applicant);
			//when
			mapper.insert(applicant);
			
			//then
			log.info(applicant);
		}

	}
}
