package com.onboarding.recruit.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onboarding.recruit.domain.ApplyVO;

@Mapper
public interface ApplyMapper {
	public ApplyVO getApply(ApplyVO applyVO);
	
	public int insert(ApplyVO applyVO);
}
