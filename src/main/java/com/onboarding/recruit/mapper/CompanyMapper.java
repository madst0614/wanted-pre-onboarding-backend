package com.onboarding.recruit.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onboarding.recruit.domain.CompanyVO;

@Mapper
public interface CompanyMapper {
	
	public int insert(CompanyVO company);
}
