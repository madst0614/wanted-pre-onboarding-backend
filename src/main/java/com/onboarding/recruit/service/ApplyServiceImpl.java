package com.onboarding.recruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboarding.recruit.domain.ApplyVO;
import com.onboarding.recruit.dto.ApplyDTO;
import com.onboarding.recruit.exception.CommonErrorCode;
import com.onboarding.recruit.exception.CustomException;
import com.onboarding.recruit.mapper.ApplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class ApplyServiceImpl implements ApplyService {
	
	@Setter(onMethod_ = @Autowired)
	private ApplyMapper mapper;

	@Transactional
	@Override
	public int register(ApplyDTO applyDTO) {
		log.info("<Apply Service> register " + applyDTO);
		ApplyVO applyVO = applyDTO.toVO();
		if (mapper.getApply(applyVO) != null)
			throw new CustomException(CommonErrorCode.ALREADY_APPLIED);

		return mapper.insert(applyVO);
	}

}
