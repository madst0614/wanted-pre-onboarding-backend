package com.onboarding.recruit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CompanyVO {
	private int cid;
	private String cname;
}
