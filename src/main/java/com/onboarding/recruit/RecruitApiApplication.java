package com.onboarding.recruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onboarding.recruit.domain.ApplicantVO;
import com.onboarding.recruit.domain.CompanyVO;
import com.onboarding.recruit.mapper.ApplicantMapper;
import com.onboarding.recruit.mapper.CompanyMapper;

import lombok.Setter;

@RestController
@RequestMapping("")
@SpringBootApplication
public class RecruitApiApplication {

	@Setter(onMethod_ = { @Autowired })
	private ApplicantMapper applicantMapper;

	@Setter(onMethod_ = @Autowired)
	private CompanyMapper companyMapper;

	public static void main(String[] args) {
		SpringApplication.run(RecruitApiApplication.class, args);

	}

	@PostMapping("/init")
	@ResponseStatus(HttpStatus.CREATED)
	public String init() {
		applicantMapper.insert(ApplicantVO.builder().uname("최승호").build());
		applicantMapper.insert(ApplicantVO.builder().uname("전재원").build());
		applicantMapper.insert(ApplicantVO.builder().uname("김방석").build());
		applicantMapper.insert(ApplicantVO.builder().uname("문산").build());
		
		companyMapper.insert(CompanyVO.builder().cname("내이버").build());
		companyMapper.insert(CompanyVO.builder().cname("카카으").build());
		companyMapper.insert(CompanyVO.builder().cname("원티드").build());
		companyMapper.insert(CompanyVO.builder().cname("쿠펑").build());
		
		return "데이터가 추가됐습니다";
	}

}

