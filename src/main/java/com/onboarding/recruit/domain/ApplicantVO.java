package com.onboarding.recruit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApplicantVO {
	private int uid;
	private String uname;
}
