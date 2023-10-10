package com.onboarding.recruit.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onboarding.recruit.domain.ApplicantVO;

@Mapper
public interface ApplicantMapper {
	
	public int insert(ApplicantVO applicant);
}
