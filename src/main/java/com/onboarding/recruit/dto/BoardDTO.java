package com.onboarding.recruit.dto;

import java.util.Date;
import java.util.List;

import com.onboarding.recruit.domain.BoardVO;

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
public class BoardDTO {
	private int bno;
	private int cid;
	private String cName;
	private String position;
	private String content;
	private Date regDate;

	// 같은 회사 다른 공고
	private List<Integer> companyBoardList;

	public BoardDTO(BoardVO vo, List<Integer> companyBoardList) {
		this.bno = vo.getBno();
		this.cid = vo.getCid();
		this.cName = vo.getCName();
		this.position = vo.getPosition();
		this.content = vo.getContent();
		this.regDate = vo.getRegDate();
		this.companyBoardList = companyBoardList;
	}

	public BoardVO toVO() {
		return BoardVO.builder().bno(this.bno).cid(this.cid).cName(this.cName).position(this.position)
				.content(this.content).regDate(this.regDate).build();
	}
}
