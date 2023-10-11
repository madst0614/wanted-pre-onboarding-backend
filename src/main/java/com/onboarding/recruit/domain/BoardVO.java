package com.onboarding.recruit.domain;

import java.util.Date;

import com.onboarding.recruit.dto.BoardDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

}
