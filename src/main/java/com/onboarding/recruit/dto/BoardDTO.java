package com.onboarding.recruit.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
	private int bno;
	private int cid;
	private String cName;
	private String position;
	private String content;
	private Date regDate;
	
	// 같은 회사 다른 공고
	private List<Integer> companyBoardList;
}
