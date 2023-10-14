package com.onboarding.recruit.dto;

import java.util.Date;

import com.onboarding.recruit.domain.ApplyVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplyDTO {
	private int bno;
	private int uid;
	private Date applyDate;
	
	public ApplyVO toVO() {
		return ApplyVO.builder().bno(this.bno).uid(this.uid).applyDate(this.applyDate).build();
	}
}
