package com.efun.pf.member.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Acel
 * @since 2017/12/21
 */
@Profile("kr")
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.efun.pf.member.service.impl.kr")
public class KrConfig {
}
