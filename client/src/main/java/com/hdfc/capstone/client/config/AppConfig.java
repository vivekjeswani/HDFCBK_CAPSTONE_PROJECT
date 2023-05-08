package com.hdfc.capstone.client.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hdfc.capstone.client.vo.EmployeeVO;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeVO restTemplate() {
        return new EmployeeVO();
    }
}