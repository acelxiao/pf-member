package com.efun.pf.member.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Acel
 * @since 2017/12/21
 */
@Profile("test")
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.efun.pf.member.service.impl.tw")
public class TestConfig extends BaseConfig{

    private String prop1;

    private String prop2;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }
}
