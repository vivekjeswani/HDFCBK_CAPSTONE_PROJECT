package com.hdfc.capstone.ClientManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hdfc.capstone.ClientManagement.vo.EmployeeVo;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeVo restTemplate() {
        return new EmployeeVo();
    }
}