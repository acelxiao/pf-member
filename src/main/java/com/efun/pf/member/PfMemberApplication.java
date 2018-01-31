package com.efun.pf.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@ComponentScan(basePackages = "com.efun.pf.member",
		excludeFilters=@ComponentScan.Filter(type = FilterType.REGEX, pattern=
				"com.efun.pf.member.service.impl.*"))
@RestController
public class PfMemberApplication {
	private static Logger logger = LoggerFactory.getLogger(PfMemberApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PfMemberApplication.class, args);
		logger.info("============================start success============================");

	}
}
