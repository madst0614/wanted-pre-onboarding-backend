package com.onboarding.recruit.domain;

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
public class BoardVO {
	private int bno;
	private int cid;
	private String cName;
	private String position;
	private String content;
	private Date regDate;
	
	// 같은 회사 다른 공고
	private List<Integer> boardList;
}
