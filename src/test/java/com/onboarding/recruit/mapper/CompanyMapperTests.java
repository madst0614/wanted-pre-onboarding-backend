package com.onboarding.recruit.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.onboarding.recruit.domain.CompanyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class CompanyMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private CompanyMapper mapper;

	@Test
	public void testInsert() {
		for (int i = 0; i < 10; i++) {
			CompanyVO company = CompanyVO.builder().cname(i+"").build();
			log.info(company);
			mapper.insert(company);
		}

	}
}
