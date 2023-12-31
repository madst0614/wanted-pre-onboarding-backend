package com.onboarding.recruit.domain;

import java.util.Date;
import java.util.List;

import com.onboarding.recruit.dto.BoardDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplyVO {
	
	private int uid;
	private int bno;
	private Date applyDate;
	
}
