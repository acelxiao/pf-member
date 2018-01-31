package com.efun.pf.member.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;

/**
 * @author Acel
 * @since 2017/12/21
 */
@Profile("tw")
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.efun.pf.member.service.impl.tw")
public class TwConfig {
}
